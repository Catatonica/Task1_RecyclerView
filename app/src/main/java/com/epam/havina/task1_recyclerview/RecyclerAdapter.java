package com.epam.havina.task1_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemHolder> {

    private final int[] itemsList;
    private final ItemClickListener listener;

    RecyclerAdapter(@NonNull final ItemClickListener listener,
                    @NonNull final int[] itemsList) {
        this.listener = listener;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new ItemHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, final int position) {
        int itemId = itemsList[position];
        holder.tvItemId.setText(String.valueOf(itemId));
    }

    @Override
    public int getItemCount() {
        return itemsList.length;
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvItemId;

        ItemHolder(@NonNull final View itemView) {
            super(itemView);
            tvItemId = itemView.findViewById(R.id.tvItemId);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(@NonNull final View view) {
            listener.onItemClicked(tvItemId.getText().toString());
        }
    }

    interface ItemClickListener {
        void onItemClicked(@NonNull final String itemId);
    }
}
