package me.free.example.sticky;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.free.example.R;
import me.free.example.sticky.sticky.StickyUtil;

public class DataListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<ItemData> mItemDataList;

    public DataListAdapter(Context context, List<ItemData> itemData) {
        this.mItemDataList = itemData;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (StickyUtil.isSticky(viewType)) {
            return new StickyHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_title, parent, false));
        }else {
            return new DefaultHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_content, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StickyHolder) {
            ((StickyHolder) holder).setTitle(mItemDataList.get(position).name);
        }
        if (holder instanceof DefaultHolder) {
            ((DefaultHolder) holder).setTitle(mItemDataList.get(position).name);
        }
    }

    @Override
    public int getItemCount() {
        return mItemDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItemDataList.get(position).getType();
    }

    static class StickyHolder extends RecyclerView.ViewHolder {

        TextView mTitle;

        StickyHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.text);
            itemView.setTag(true);
        }

        public void setTitle(String title) {
            this.mTitle.setText(title);
        }
    }

    static class DefaultHolder extends RecyclerView.ViewHolder {

        TextView mTitle;

        DefaultHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.text);
            itemView.setTag(false);
        }

        public void setTitle(String title) {
            this.mTitle.setText(title);
        }
    }
}
