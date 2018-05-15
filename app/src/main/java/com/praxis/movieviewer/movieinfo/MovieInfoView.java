package com.praxis.movieviewer.movieinfo;

import android.content.Context;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;

public interface MovieInfoView {

  void showProgress();

  void hideProgress();

  void setMovieInfo(MovieInfo movieInfo);

  void openSeatMap(MovieSeatSelectionInfo movieSeatSelectionInfo);

  Context getContext();

}
