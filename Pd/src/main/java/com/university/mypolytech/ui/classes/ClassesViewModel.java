package com.university.mypolytech.ui.classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClassesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ClassesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Здесь должны быть занятия, но они в zoom.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}