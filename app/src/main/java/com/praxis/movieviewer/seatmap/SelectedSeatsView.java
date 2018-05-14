package com.praxis.movieviewer.seatmap;

import android.content.Context;

public interface SelectedSeatsView {

  void addSeat(SelectedSeatView seatView);

  void removeSeat(SelectedSeatView seatView);

  Context getContext();

  int getMaxNoOfSeats();

  void showMaxSeatsError();

}
