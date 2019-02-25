package ca.leomoraes.fulllabstore.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import ca.leomoraes.fulllabstore.model.TriggerResponse;

public class MainLiveData extends MediatorLiveData<TriggerResponse> {
    public MainLiveData(LiveData<String> query, LiveData<Integer> page) {
        addSource(query, first -> setValue(new TriggerResponse(first, page.getValue(), true)));
        addSource(page, second -> setValue(new TriggerResponse(query.getValue(), second, false)));
    }
}