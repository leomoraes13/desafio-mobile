package ca.leomoraes.fulllabstore.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_text)
    TextView textView;

    @BindView(R.id.main_progress)
    ProgressBar progressBar;

    @BindView(R.id.main_search_editText)
    EditText searchEdit;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupViewModel();
    }

    private void setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getProducts().observe(this, products -> {
            updateLayout(products);
            progressBar.setVisibility(View.GONE);
        });
    }

    private void updateLayout(List<Product> products) {
        textView.setText("");
        for (Product prod:products) {
            textView.append(prod.getName() + " - " + prod.getBrand() + "\n");
        }
    }

    @OnClick(R.id.main_search_button)
    public void search(){
        progressBar.setVisibility(View.VISIBLE);
        String query = searchEdit.getText().toString();
        viewModel.setQuery( query );
    }
}
