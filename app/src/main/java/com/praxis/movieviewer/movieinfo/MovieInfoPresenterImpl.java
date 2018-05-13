package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;

public class MovieInfoPresenterImpl implements MovieInfoPresenter, GetMovieInfoInteractor.OnFinishedListener {

  private MovieInfoView movieInfoView;
  private GetMovieInfoInteractor getMovieInfoInteractor;

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

  }

  @Override
  public void onFinished(MovieInfo movieInfo) {
    if(movieInfoView != null) {
      movieInfoView.setMovieInfo(movieInfo);
      movieInfoView.hideProgress();
    }
  }
}
