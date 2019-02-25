package ca.leomoraes.fulllabstore.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.model.ProductResponse;
import ca.leomoraes.fulllabstore.repository.MainRepository;

public class MainViewModel extends AndroidViewModel {

    private final MutableLiveData<String> queryLiveData = new MutableLiveData();
    private final MutableLiveData<Integer> pageLiveData = new MutableLiveData<>();
    private List<Product> mProductList = new ArrayList<>();
    private int page;
    private final int PAGE_SIZE = 10;

    private MainLiveData trigger = new MainLiveData(queryLiveData, pageLiveData);

    // Response
    private final LiveData<ProductResponse> responseLiveData =
            Transformations.switchMap(trigger, value -> {
                if(value.isQueryChange()){
                    mProductList = new ArrayList<>();
                    page=0;
                }
                return MainRepository.getInstance().getProducts(page*PAGE_SIZE, PAGE_SIZE, value.getQuery());
            });

    // List of products
    private final LiveData<List<Product>> productsLiveData =
            Transformations.switchMap(responseLiveData, value -> {
                MutableLiveData<List<Product>> productsLiveData = new MutableLiveData<>();
                mProductList.addAll(value.getProducts());
                productsLiveData.postValue(mProductList);
                return productsLiveData;
            });

    public MainViewModel(@NonNull Application application) {
        super(application);
        page = 0;
        pageLiveData.setValue(page);
    }

    public LiveData<List<Product>> getProducts() {
        return productsLiveData;
    }

    public void setQuery(String query) {
        queryLiveData.setValue(query);
    }
    public void setPage() {
        if(pageLiveData!=null && pageLiveData.getValue()!=null) {
            pageLiveData.setValue(++page);
        }
    }
}