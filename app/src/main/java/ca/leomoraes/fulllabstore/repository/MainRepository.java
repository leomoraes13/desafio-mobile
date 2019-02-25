package ca.leomoraes.fulllabstore.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.leomoraes.fulllabstore.api.ApiService;
import ca.leomoraes.fulllabstore.model.BestInstallment;
import ca.leomoraes.fulllabstore.model.Image;
import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.model.ProductResponse;
import ca.leomoraes.fulllabstore.model.Seller;
import ca.leomoraes.fulllabstore.model.Sku;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private static class SingletonHelper {
        private static final MainRepository INSTANCE = new MainRepository();
    }
    public static MainRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public MainRepository() {
    }

    public LiveData<ProductResponse> getProducts(int page, int size, String query) {
        final MutableLiveData<ProductResponse> data = new MutableLiveData<>();

        if(query==null)
            query = "";

        ApiService
            .getInstance()
            .getProducts(
                page,
                size,
                query,
                new Callback<ProductResponse>() {
                    @Override
                    public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            data.postValue(response.body());
                        }else{
                            data.postValue(null);
                        }
                    }
                    @Override
                    public void onFailure(Call<ProductResponse> call, Throwable t) {
                        data.postValue(null);
                    }
                }
            );

        return data;
    }
}
