package com.example.charles.teketeke;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charles.teketeke.network.ImageRequester;
import com.example.charles.teketeke.network.ProductEntry;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class SupermarketCardRecyclerViewAdapter extends RecyclerView.Adapter<SupermarketCardViewHolder> {

    private List<ProductEntry> productList;
    private ImageRequester imageRequester;

    SupermarketCardRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public SupermarketCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.supermarket_card, parent, false);
        return new SupermarketCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull SupermarketCardViewHolder holder, int position) {
        if (productList != null && position < productList.size()) {
            ProductEntry product = productList.get(position);
            holder.productTitle.setText(product.title);
            holder.productPrice.setText(product.price);
            imageRequester.setImageFromUrl(holder.productImage, product.url);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
