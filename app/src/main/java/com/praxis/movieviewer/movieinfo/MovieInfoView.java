package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfo;

public interface MovieInfoView {

  void showProgress();

  void hideProgress();

  void setMovieInfo(MovieInfo movieInfo);

  void openSeatMap(MovieSeatMapInfo movieSeatMapInfo);

}
