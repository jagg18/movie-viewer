package com.praxis.movieviewer.movieinfo.data;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;

public interface GetMovieInfoInteractor {

  interface OnFinishedListener {
    void onFinished(MovieInfo movieInfo);
  }

  void getMovieInfo(OnFinishedListener listener);
}
