package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfo;
import com.praxis.movieviewer.seatmap.models.SeatInfo;

public class SeatMapPresenterImpl implements SeatMapPresenter {

  private SeatMapView seatMapView;
  private MovieSeatMapInfo movieSeatMapInfo;

  private SelectedSeatsPresenter selectedSeatsPresenter;

  public SeatMapPresenterImpl(SeatMapView seatMapView, MovieSeatMapInfo movieSeatMapInfo) {
    this.seatMapView = seatMapView;

    // set data immediately
    seatMapView.setMovieSeatMapInfo(movieSeatMapInfo);

    selectedSeatsPresenter = new SelectedSeatsPresenterImpl(seatMapView.getSelectedSeatsView());
  }

  @Override
  public void getSeatMap() {
//    seatMapView.setMovieSeatMapInfo(movieSeatMapInfo);
  }

  @Override
  public void selectSeat(SeatInfo seatInfo) {
    selectedSeatsPresenter.selectSeat(seatInfo);
  }
}
