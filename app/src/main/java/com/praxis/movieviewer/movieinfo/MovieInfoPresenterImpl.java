package com.praxis.movieviewer.movieinfo;

import com.praxis.movieviewer.movieinfo.models.MovieInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfoImpl;

public class MovieInfoPresenterImpl implements MovieInfoPresenter, GetMovieInfoInteractor.OnFinishedListener {

  private MovieInfoView movieInfoView;
  private GetMovieInfoInteractor getMovieInfoInteractor;

  private MovieInfo movieInfo;

  public MovieInfoPresenterImpl(MovieInfoView movieInfoView) {
    this.movieInfoView = movieInfoView;

    // init interactor
    this.getMovieInfoInteractor = new GetMovieInfoInteractorProdImpl();
//    this.getMovieInfoInteractor = new GetMovieInfoInteractorLocalImpl(movieInfoView.getContext());
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
    MovieSeatSelectionInfo movieSeatSelectionInfo = new MovieSeatSelectionInfoImpl(movieInfo.getMovieId(), movieInfo.getTheater());
    movieInfoView.openSeatMap(movieSeatSelectionInfo);
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
