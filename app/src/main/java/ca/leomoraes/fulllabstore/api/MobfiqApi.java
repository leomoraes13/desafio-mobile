package ca.leomoraes.fulllabstore.api;

import ca.leomoraes.fulllabstore.model.CategoryResponse;
import ca.leomoraes.fulllabstore.model.ProductRequest;
import ca.leomoraes.fulllabstore.model.ProductResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MobfiqApi {

    String URL = "https://desafio.mobfiq.com.br/";

    @POST("Search/Criteria")
    Call<ProductResponse> getProducts(
            @Body ProductRequest request
    );

    @GET("StorePreference/CategoryTree")
    Call<CategoryResponse> getCategories();
}
