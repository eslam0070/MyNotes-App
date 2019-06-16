package com.egyeso.mynotes.activity.main;


import com.egyeso.mynotes.models.Note;

import java.util.List;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<Note> note);
    void onErrorLoading(String message);
}
