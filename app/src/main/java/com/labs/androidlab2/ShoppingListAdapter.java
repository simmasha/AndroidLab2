package com.labs.androidlab2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.labs.androidlab2.R;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ProductViewHolder> {

    private final List<String> products;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        private final TextView product;

        private final Button removeButton;

        public ProductViewHolder(View view) {
            super(view);
            product = (TextView) view.findViewById(R.id.product);
            removeButton = (Button) view.findViewById(R.id.removeButton);
        }

        public TextView getProduct() {
            return product;
        }

        public Button getRemoveButton() {
            return removeButton;
        }
    }

    public ShoppingListAdapter(List<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getProduct().setText(products.get(position));
        holder.getRemoveButton().setOnClickListener(v -> clear(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void save(String productName, String productNumber) {
        products.add(productName + " " + productNumber + " шт.");
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear(int position) {
        products.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearAll() {
        products.clear();
        notifyDataSetChanged();
    }
}