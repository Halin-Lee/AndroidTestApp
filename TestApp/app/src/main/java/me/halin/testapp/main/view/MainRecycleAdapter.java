package me.halin.testapp.main.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.halin.testapp.BR;
import me.halin.testapp.MainItemBinding;
import me.halin.testapp.R;
import me.halin.testapp.main.MainDataHolder;
import me.halin.testapp.main.Model.TestItem;

/**
 * Created by halin on 9/18/15.
 */
public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.MainViewHolder> {


    public static final String TAG = MainRecycleAdapter.class.getSimpleName();

    public final MainDataHolder mHolder;

    public MainRecycleAdapter(MainDataHolder holder) {
        mHolder = holder;


        //添加监听,list的所有改变都调用notifyDataSetChanged改变内容
        holder.testList.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                notifyDataSetChanged();
            }
        });

    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //构造binding,设置holder,绑定点击回调
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.activity_main_item, parent, false);
        binding.setVariable(BR.dataHolder, mHolder);
        View view = binding.getRoot();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainItemBinding binding = DataBindingUtil.getBinding(v);
                int index = binding.getIndex();
                TestItem item = mHolder.testList.get(index);
                mHolder.itemClickListener.get().onItemClick(item);
            }
        });
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        //为binding设置index
        binding.setVariable(BR.index, position);
    }

    @Override
    public int getItemCount() {
        return mHolder.testList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
