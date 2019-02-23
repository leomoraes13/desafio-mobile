package ca.leomoraes.fulllabstore.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import ca.leomoraes.fulllabstore.api.ApiService;
import ca.leomoraes.fulllabstore.model.Category;
import ca.leomoraes.fulllabstore.model.CategoryResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private static class SingletonHelper {
        private static final CategoryRepository INSTANCE = new CategoryRepository();
    }
    public static CategoryRepository getInstance() {
        return CategoryRepository.SingletonHelper.INSTANCE;
    }

    public CategoryRepository() {
    }

    public LiveData<List<Category>> getCategories() {
        final MutableLiveData<List<Category>> data = new MutableLiveData<>();

        ApiService
            .getInstance()
            .getCategories(
                new Callback<CategoryResponse>() {
                    @Override
                    public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            data.postValue(response.body().getCategories());
                        }else{
                            data.postValue(null);
                        }
                    }
                    @Override
                    public void onFailure(Call<CategoryResponse> call, Throwable t) {
                        data.postValue(null);
                    }
                }
            );

        return data;
    }
}
