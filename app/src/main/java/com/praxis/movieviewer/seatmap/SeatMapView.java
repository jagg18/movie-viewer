package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfo;

public interface SeatMapView {

  void setMovieSeatMapInfo(MovieSeatMapInfo movieSeatMapInfo);

  SelectedSeatsView getSelectedSeatsView();

  void setTotalPrice(String price);

}
