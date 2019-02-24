package ca.leomoraes.fulllabstore.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.adapter.ProductAdapter;
import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_recycler)
    RecyclerView mRecycler;

    @BindView(R.id.main_searh_box)
    CardView searchBox;

    @BindView(R.id.main_search_editText)
    EditText searchEdit;

    private MainViewModel viewModel;
    private ProductAdapter mAdapter;

    @Override
    int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupRecycler();
    }

    private void setupRecycler() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(layoutManager);
        mAdapter = new ProductAdapter();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    void setupViewModel() {
        displayLoading();
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getProducts().observe(this, products -> {
            updateLayout(products);
            hideLoading();
        });
    }

    private void updateLayout(List<Product> products) {
        if(products!=null && !products.isEmpty()) {
            mAdapter.setProducts(products);
        }else{
            displayErrorMessage(R.string.erro_server, null);
        }
    }

    @OnClick(R.id.main_search_button)
    public void search(){
        searchBox.setVisibility(View.GONE);
        displayLoading();
        String query = searchEdit.getText().toString();
        viewModel.setQuery( query );
        searchEdit.clearFocus();
    }

    @OnClick(R.id.main_close_button)
    public void close(){
        searchBox.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_category:
                intent = new Intent(this, CategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_search:
                searchBox.setVisibility(View.VISIBLE);
                searchEdit.requestFocus();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
