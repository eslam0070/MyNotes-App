package com.egyeso.mynotes.activity.editor;

import com.egyeso.mynotes.api.ApiClient;
import com.egyeso.mynotes.api.ApiInterface;
import com.egyeso.mynotes.models.Note;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {

    private EditorView view;

    public EditorPresenter(EditorView view) {
        this.view = view;
    }

    void saveNote(final String title, final String note,final int color) {
        view.showProgress();

        try {
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<Note> call = apiInterface.SaveNote(title, note, color);
            call.enqueue(new Callback<Note>() {
                @Override
                public void onResponse(Call<Note> call, Response<Note> response) {
                    view.hideProgress();
                    if (response.isSuccessful() && response.body() != null){
                        Boolean success = response.body().getSuccess();
                        if (success){
                            view.onRequestSuccess(response.body().getMessage());
                        }else{
                            view.onRequestError(response.body().getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Call<Note> call, Throwable t) {
                    view.hideProgress();
                    view.onRequestError(t.getLocalizedMessage());
                }
            });
        }catch (IllegalStateException e){
            e.getMessage();
        }
    }
    void updateNote(int id , String title , String note , int color){
        view.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.UpdateNote(id,title,note,color).enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if (success){
                        view.onRequestSuccess(response.body().getMessage());
                    }else {
                        view.onRequestError(response.body().getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());
            }
        });
    }
    void deleteNote(int id){
        view.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.DeleteNote(id).enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if (success){
                        view.onRequestSuccess(response.body().getMessage());
                    }else {
                        view.onRequestError(response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());
            }
        });
    }
}
