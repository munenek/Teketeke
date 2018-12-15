package com.example.charles.teketeke;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charles.teketeke.network.ProductEntry;

public class Supermarkets extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment with the ProductGrid theme
        View view = inflater.inflate(R.layout.fragment_supermarkets, container, false);

        // Set up the toolbar
        setUpToolbar(view);
        //Setup recyclerview
        RecyclerView reyclerView = view.findViewById(R.id.recycler_view);
        reyclerView.setHasFixedSize(true);
        reyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
       SupermarketCardRecyclerViewAdapter adapter = new SupermarketCardRecyclerViewAdapter(ProductEntry.initProductEntryList(getResources()));
       reyclerView.setAdapter(adapter);
        int largepaddng=getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallpaddng=getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        reyclerView.addItemDecoration(new supermarketGridItemDecoration(largepaddng,smallpaddng));
        return view;
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

}