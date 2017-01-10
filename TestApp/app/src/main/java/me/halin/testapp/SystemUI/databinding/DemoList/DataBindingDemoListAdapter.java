package me.halin.testapp.SystemUI.databinding.DemoList;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.halin.testapp.BR;
import me.halin.testapp.R;

/**
 * 使用Index作为子view内容选项的DEMO
 *
 *
 * Created by halin on 9/13/15.
 */
public class DataBindingDemoListAdapter extends RecyclerView.Adapter<DataBindingDemoListAdapter.DataBindingDemoListViewHolder>{

    public final ObservableArrayList<String> mDataList = new ObservableArrayList<>();

    public void setDataList(List<String> dataList) {
        mDataList.clear();
        mDataList.addAll(dataList);
    }

    public List<String> getDataList(){
        return new ArrayList<>(mDataList);
    }

    @Override
    public DataBindingDemoListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //根据类型创建不同的view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_binding_demo_list_recycle_view_item,null);
        DataBindingUtil.bind(v).setVariable(BR.observableList,mDataList);
        return new DataBindingDemoListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataBindingDemoListViewHolder dataBindingRecycleViewHolder, int i) {
        //两套layout使用同一个string参数
        dataBindingRecycleViewHolder.getBinding().setVariable(BR.index,i);
//        dataBindingRecycleViewHolder.getBinding().executePendingBindings();
    }


    @Override
    public int getItemViewType(int position) {
        //构造两种view类型
        return position%2;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    //TODO:选中状态的标示
    protected class DataBindingDemoListViewHolder extends RecyclerView.ViewHolder{

        public ViewDataBinding getBinding(){
            return DataBindingUtil.getBinding(this.itemView);
        }

        public DataBindingDemoListViewHolder(View itemView) {
            super(itemView);
        }
    }

}
