package ca.leomoraes.fulllabstore.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_text)
    TextView textView;

    @BindView(R.id.main_searh_box)
    CardView searchBox;

    @BindView(R.id.main_search_editText)
    EditText searchEdit;

    private MainViewModel viewModel;

    @Override
    int getLayoutResId() {
        return R.layout.activity_main;
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
        // Exibir imagens, preço de tabela, preço final, melhor opção de parcelamento e desconto

        textView.setText("");
        if(products!=null && !products.isEmpty()) {
            for (Product prod : products) {
                textView.append(prod.getName() + " - " + prod.getSkus().get(0).getSellers().get(0).getPrice() + " / " + prod.getSkus().get(0).getSellers().get(0).getListPrice() + "\n");
            }
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
