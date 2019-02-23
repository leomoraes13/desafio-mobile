package ca.leomoraes.fulllabstore.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import ca.leomoraes.fulllabstore.api.ApiService;
import ca.leomoraes.fulllabstore.model.Product;
import ca.leomoraes.fulllabstore.model.ProductResponse;
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

    public LiveData<List<Product>> getProducts(int page, int size, String query) {
        final MutableLiveData<List<Product>> data = new MutableLiveData<>();

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
                            data.postValue(response.body().getProducts());
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
