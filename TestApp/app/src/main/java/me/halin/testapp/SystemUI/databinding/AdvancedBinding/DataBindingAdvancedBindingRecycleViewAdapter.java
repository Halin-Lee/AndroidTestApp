package me.halin.testapp.SystemUI.databinding.AdvancedBinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableMap;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.halin.testapp.BR;
import me.halin.testapp.R;

/**
 * Created by halin on 9/13/15.
 */
public class DataBindingAdvancedBindingRecycleViewAdapter extends RecyclerView.Adapter<DataBindingAdvancedBindingRecycleViewAdapter.DataBindingRecycleViewHolder> {


    private String[] mDataSet;

    public DataBindingAdvancedBindingRecycleViewAdapter(String[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public DataBindingRecycleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //根据类型创建不同的view
        View v = null;
        switch (i){
            case 0:
                v =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_binding_advanced_binding_recycle_view_item_a,null);
                break;
            case 1:
                v =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_binding_advanced_binding_recycle_view_item_b,null);
                break;
        }
        DataBindingUtil.bind(v);
        return new DataBindingRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataBindingRecycleViewHolder dataBindingRecycleViewHolder, int i) {
        //两套layout使用同一个string参数
        dataBindingRecycleViewHolder.getBinding().setVariable(BR.string,mDataSet[i]);
        dataBindingRecycleViewHolder.getBinding().executePendingBindings();
    }


    @Override
    public int getItemViewType(int position) {
        //构造两种view类型
        return position%2;
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    protected class DataBindingRecycleViewHolder extends RecyclerView.ViewHolder{

        public ViewDataBinding getBinding(){
            return DataBindingUtil.getBinding(this.itemView);
        }

        public DataBindingRecycleViewHolder(View itemView) {
            super(itemView);
        }
    }

}
