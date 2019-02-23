package ca.leomoraes.fulllabstore.api;

import java.util.concurrent.TimeUnit;

import ca.leomoraes.fulllabstore.model.CategoryResponse;
import ca.leomoraes.fulllabstore.model.ProductRequest;
import ca.leomoraes.fulllabstore.model.ProductResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final long TIMEOUT = 120;
    private MobfiqApi mobfiqApi;

    private static class SingletonHelper {
        private static final ApiService INSTANCE = new ApiService();
    }
    public static ApiService getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public ApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS).build();

        mobfiqApi = new Retrofit.Builder()
                .baseUrl(MobfiqApi.URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MobfiqApi.class);
    }

    public void getProducts(int page, int size, String query, Callback<ProductResponse> callback){
        Call<ProductResponse> jsonCall = mobfiqApi.getProducts( new ProductRequest(query, size, page) );
        jsonCall.enqueue(callback);
    }

    public void getCategories(Callback<CategoryResponse> callback){
        Call<CategoryResponse> jsonCall = mobfiqApi.getCategories();
        jsonCall.enqueue(callback);
    }
}
