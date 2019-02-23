package ca.leomoraes.fulllabstore.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.model.Category;
import ca.leomoraes.fulllabstore.viewmodel.CategoryViewModel;

public class CategoryActivity extends BaseActivity {

    @BindView(R.id.category_text)
    TextView textView;

    private CategoryViewModel viewModel;

    @Override
    int getLayoutResId() {
        return R.layout.activity_category;
    }

    @Override
    void setupViewModel() {
        displayLoading();
        viewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        viewModel.getCategories().observe(this, categories -> {
            updateLayout(categories);
            hideLoading();
        });
    }

    private void updateLayout(List<Category> categories) {
        textView.setText("");
        if(categories!=null && !categories.isEmpty()) {
            for (Category category : categories) {
                textView.append(category.getName() + " - " + category.getIcon() + "\n");
            }
        }else{
            displayErrorMessage(R.string.erro_server, null);
        }
    }

}
