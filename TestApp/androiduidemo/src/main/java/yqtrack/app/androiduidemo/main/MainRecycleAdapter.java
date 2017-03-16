package yqtrack.app.androiduidemo.main;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yqtrack.app.androiduidemo.BR;
import yqtrack.app.androiduidemo.R;
import yqtrack.app.androiduidemo.databinding.ItemMainBinding;
import yqtrack.app.androiduidemo.main.model.TestItem;


/**
 * Created by halin on 9/18/15.
 */
public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.MainViewHolder> {


    public static final String TAG = MainRecycleAdapter.class.getSimpleName();

    public final MainViewModel viewModel;

    public MainRecycleAdapter(MainViewModel viewModel) {
        this.viewModel = viewModel;


        //添加监听,list的所有改变都调用notifyDataSetChanged改变内容
        viewModel.testList.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
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
        ItemMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main, parent, false);
        binding.setViewModel(viewModel);

        View view = binding.getRoot();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemMainBinding binding = DataBindingUtil.getBinding(v);
                int index = binding.getIndex();
                TestItem item = viewModel.testList.get(index);
                viewModel.itemClickListener.get().onItemClick(item);
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
        return viewModel.testList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
