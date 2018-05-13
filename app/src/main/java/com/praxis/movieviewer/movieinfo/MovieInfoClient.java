package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfoImpl;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInfoClient {

  @GET("http://ec2-52-76-75-52.ap-southeast-1.compute.amazonaws.com/movie.json")
  Call<MovieInfoImpl> getMovieInfo();

}
