package ca.leomoraes.fulllabstore.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.leomoraes.fulllabstore.model.Product;

public class MainRepository {

    private static class SingletonHelper {
        private static final MainRepository INSTANCE = new MainRepository();
    }
    public static MainRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public MainRepository() {
    }

    public LiveData<List<Product>> getProducts() {
        final MutableLiveData<List<Product>> data = new MutableLiveData<>();

        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(() -> {
            simulateDelay();
            List<Product> list = new ArrayList<>();
            list.add(new Product("Name 1", "Brand 1"));
            list.add(new Product("Name 2", "Brand 2"));
            list.add(new Product("Name 3", "Brand 3"));
            list.add(new Product("Name 4", "Brand 4"));

            data.postValue( list );
        });


        return data;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
