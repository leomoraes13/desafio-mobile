package ca.leomoraes.fulllabstore.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import java.util.List;

import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.repository.MainRepository;

public class MainViewModel extends AndroidViewModel {

    private final MutableLiveData<String> queryLiveData = new MutableLiveData();

    // List of products
    private final LiveData<List<Product>> productsLiveData =
            Transformations.switchMap(queryLiveData, (query) -> MainRepository.getInstance().getProducts(0, 10, query));

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.setQuery("");
    }

    public LiveData<List<Product>> getProducts() {
        return productsLiveData;
    }

    public void setQuery(String query) {
        queryLiveData.setValue(query);
    }
}