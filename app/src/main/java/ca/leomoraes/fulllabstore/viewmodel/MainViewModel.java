package ca.leomoraes.fulllabstore.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.repository.MainRepository;

public class MainViewModel extends AndroidViewModel {

    // List of products
    private LiveData<List<Product>> productsLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        productsLiveData = MainRepository.getInstance().getProducts();
    }

    public LiveData<List<Product>> getProducts() {
        return productsLiveData;
    }

}