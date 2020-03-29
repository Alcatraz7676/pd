package com.university.mypolytech.ui.session;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SessionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SessionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Видишь сессии? Нет? А они есть.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}