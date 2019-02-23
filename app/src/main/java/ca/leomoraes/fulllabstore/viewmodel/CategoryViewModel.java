package ca.leomoraes.fulllabstore.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import ca.leomoraes.fulllabstore.model.Category;
import ca.leomoraes.fulllabstore.repository.CategoryRepository;

public class CategoryViewModel extends AndroidViewModel {

    // List of categories
    private LiveData<List<Category>> categoriesLiveData;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        categoriesLiveData = CategoryRepository.getInstance().getCategories();
    }

    public LiveData<List<Category>> getCategories() {
        return categoriesLiveData;
    }
}
