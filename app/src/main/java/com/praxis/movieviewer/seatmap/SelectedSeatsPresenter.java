package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.SeatInfo;

public interface SelectedSeatsPresenter {

  void addSeat(SeatInfo seatInfo);

  void removeSeat(SeatInfo seatInfo);

  void selectSeat(SeatInfo seatInfo);

}
