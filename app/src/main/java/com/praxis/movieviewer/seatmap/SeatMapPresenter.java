package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.SeatInfo;

public interface SeatMapPresenter {

  void getSeatMap();

  void selectSeat(SeatInfo seatInfo);

}
