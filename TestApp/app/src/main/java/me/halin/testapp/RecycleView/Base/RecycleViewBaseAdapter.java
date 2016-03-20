package me.halin.testapp.RecycleView.Base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.halin.testapp.R;

/**
 * Created by halin on 9/13/15.
 */
public class RecycleViewBaseAdapter extends RecyclerView.Adapter<RecycleViewBaseAdapter.RecycleViewBaseViewHolder> {

    private String[] mDataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, andß
    // you provide access to all the views for a data item in a view holder
    public static class RecycleViewBaseViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout linearLayout;
        public TextView textView;
        public RecycleViewBaseViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
            textView = (TextView) v.findViewById(R.id.text);
        }
    }

    public RecycleViewBaseAdapter(String[] myDataset) {
        mDataSet = myDataset;
    }

    @Override
    public RecycleViewBaseViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_base_item, parent, false);
        RecycleViewBaseViewHolder vh = new RecycleViewBaseViewHolder((LinearLayout)v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecycleViewBaseViewHolder holder, int position) {
       holder.textView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
