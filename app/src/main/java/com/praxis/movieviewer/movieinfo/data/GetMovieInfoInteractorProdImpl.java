package com.praxis.movieviewer.movieinfo.data;

import android.util.Log;

import com.praxis.movieviewer.ServiceGenerator;
import com.praxis.movieviewer.movieinfo.models.MovieInfoImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMovieInfoInteractorProdImpl implements GetMovieInfoInteractor {

  MovieInfoClient client;

  public GetMovieInfoInteractorProdImpl() {
    client = ServiceGenerator.createService(MovieInfoClient.class);
  }

  @Override
  public void getMovieInfo(final OnFinishedListener listener) {
    Call<MovieInfoImpl> call = client.getMovieInfo();
    call.enqueue(new Callback<MovieInfoImpl>() {
      @Override
      public void onResponse(Call<MovieInfoImpl> call, Response<MovieInfoImpl> response) {
        if(response.isSuccessful()) {
          listener.onFinished(response.body());
        } else {
          // error response, no access to resource?
        }
      }

      @Override
      public void onFailure(Call<MovieInfoImpl> call, Throwable t) {
        // something went completely south (like no internet connection)
        Log.d("Error", t.getMessage());
      }
    });
  }

}
