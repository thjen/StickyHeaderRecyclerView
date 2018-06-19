package qthjen_dev.io.stickyheaderrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class MAdapter extends StatelessSection {

    private String title;
    private List<String> list;
    private Context context;

    public MAdapter(String title, List<String> list, Context context) {
        super(SectionParameters.builder().itemResourceId(R.layout.ll_item).headerResourceId(R.layout.ll_header)
        .build());
        this.title = title;
        this.list = list;
        this.context = context;
    }

//    public MAdapter(SectionParameters sectionParameters) {
//        super(sectionParameters);
//    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.tvName.setText(list.get(position));

        itemViewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        headerViewHolder.tvheader.setText(title);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final View root;

        public ItemViewHolder(View itemView) {
            super(itemView);

            root = itemView;
            tvName = itemView.findViewById(R.id.itemName);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvheader;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvheader = itemView.findViewById(R.id.header);
        }
    }
}
