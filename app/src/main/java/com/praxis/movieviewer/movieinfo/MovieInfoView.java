package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;

public interface MovieInfoView {

  void showProgress();

  void hideProgress();

  void setMovieInfo(MovieInfo movieInfo);

  void openSeatMap();

}
