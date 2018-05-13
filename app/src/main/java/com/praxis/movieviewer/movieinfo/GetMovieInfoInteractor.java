package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;

public interface GetMovieInfoInteractor {

  interface OnFinishedListener {
    void onFinished(MovieInfo movieInfo);
  }

  void getMovieInfo(OnFinishedListener listener);
}
