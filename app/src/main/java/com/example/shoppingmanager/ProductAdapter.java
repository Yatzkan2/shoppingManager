package com.example.shoppingmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> productList;
    private Context context;

    public ProductAdapter(ArrayList<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product);

        // Set remove button click listener
        holder.removeButton.setOnClickListener(v -> {
            removeProduct(position);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    private void removeProduct(int position) {
        productList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, productList.size());
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView priceTextView;
        TextView amountTextView;
        Button removeButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.product_name);
            priceTextView = itemView.findViewById(R.id.product_price);
            amountTextView = itemView.findViewById(R.id.product_amount);
            removeButton = itemView.findViewById(R.id.remove_product_button);
        }

        public void bind(Product product) {
            nameTextView.setText(product.getName());
            priceTextView.setText(String.format("$%.2f", product.getPrice()));
            amountTextView.setText(String.valueOf(product.getAmount()));
        }
    }
}
