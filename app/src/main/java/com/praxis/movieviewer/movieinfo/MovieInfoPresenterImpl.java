package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfoImpl;

public class MovieInfoPresenterImpl implements MovieInfoPresenter, GetMovieInfoInteractor.OnFinishedListener {

  private MovieInfoView movieInfoView;
  private GetMovieInfoInteractor getMovieInfoInteractor;

  private MovieInfo movieInfo;

  public MovieInfoPresenterImpl(MovieInfoView movieInfoView) {
    this.movieInfoView = movieInfoView;

    // init interactor
    this.getMovieInfoInteractor = new GetMovieInfoInteractorProdImpl();
  }

  @Override
  public void onResume() {
    if(movieInfoView != null) {
      movieInfoView.showProgress();
    }

    getMovieInfoInteractor.getMovieInfo(this);
  }

  @Override
  public void onDestroy() {
    movieInfoView = null;
  }

  @Override
  public void onViewSeatMap() {
    MovieSeatMapInfo movieSeatMapInfo = new MovieSeatMapInfoImpl(movieInfo.getMovieId(), movieInfo.getTheater());
    movieInfoView.openSeatMap(movieSeatMapInfo);
  }

  @Override
  public void onFinished(MovieInfo movieInfo) {
    // record data
    this.movieInfo = movieInfo;

    if(movieInfoView != null) {
      movieInfoView.setMovieInfo(movieInfo);
      movieInfoView.hideProgress();
    }
  }
}
