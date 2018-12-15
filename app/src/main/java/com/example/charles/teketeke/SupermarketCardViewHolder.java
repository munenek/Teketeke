package com.example.charles.teketeke;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.charles.teketeke.application.barcodereader.BarcodeCaptureActivity;

public class SupermarketCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView productImage;
    public TextView productTitle;
    public TextView productPrice;

    public SupermarketCardViewHolder(@NonNull View itemView) {
        super(itemView);
        productImage = itemView.findViewById(R.id.product_image);
        productTitle = itemView.findViewById(R.id.product_title);
        productPrice = itemView.findViewById(R.id.product_price);

        productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent in=new Intent(view.getContext(),BarcodeCaptureActivity.class);
                view.getContext().startActivity(in);

            }
        });
    }


}
