package halin.me.testapp.main.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import halin.me.testapp.BR;
import halin.me.testapp.R;
import halin.me.testapp.main.MainDataHolder;
import halin.me.testapp.main.Model.TestGroup;
import halin.me.testapp.main.Model.TestItem;

/**
 * Created by halin on 9/18/15.
 */
public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.MainViewHolder> {

    private final List<Object> mData = new ArrayList<>();

    public MainRecycleAdapter(MainDataHolder holder) {
        holder.testList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<TestGroup>>() {
            @Override
            public void onChanged(ObservableList<TestGroup> sender) {
                generatedData(sender);
            }

            @Override
            public void onItemRangeChanged(ObservableList<TestGroup> sender, int positionStart, int itemCount) {

            }

            @Override
            public void onItemRangeInserted(ObservableList<TestGroup> sender, int positionStart, int itemCount) {

            }

            @Override
            public void onItemRangeMoved(ObservableList<TestGroup> sender, int fromPosition, int toPosition, int itemCount) {

            }

            @Override
            public void onItemRangeRemoved(ObservableList<TestGroup> sender, int positionStart, int itemCount) {

            }
        });
        generatedData(holder.testList);
    }


    private void generatedData(ObservableList<TestGroup> sender) {
        mData.clear();
        for (TestGroup group : sender){
            mData.add(group);
            for (TestItem item :group.items ) {
                mData.add(item);
            }
        }
    }




    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("",""+viewType);
        View view =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),viewType,parent,false).getRoot() ;
        return new MainViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if ( mData.get(position) instanceof TestGroup){
            return R.layout.activity_main_header;
        }else {
            return R.layout.activity_main_item;
        }
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        Object obj = mData.get(position);
        switch (getItemViewType(position)){
            case R.layout.activity_main_header:
                binding.setVariable(BR.testGroup,obj);
                break;
            case R.layout.activity_main_item:
                binding.setVariable(BR.testItem,obj);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
