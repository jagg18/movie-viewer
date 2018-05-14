package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfo;
import com.praxis.movieviewer.seatmap.models.SeatInfo;

import java.text.DecimalFormat;

public class SeatMapPresenterImpl implements SeatMapPresenter {

  private final String FORMAT_PRICE = "PhP #,##0.00";

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

    double totalPrice = selectedSeatsPresenter.getTotalPrice();
    // set total price in view
    seatMapView.setTotalPrice(getFormattedPrice(totalPrice));
  }

  private String getFormattedPrice(double price) {
//    NumberFormat format = NumberFormat.getCurrencyInstance();
//    return format.format(price);

    DecimalFormat format = new DecimalFormat(FORMAT_PRICE);
    return format.format(price);
  }
}
