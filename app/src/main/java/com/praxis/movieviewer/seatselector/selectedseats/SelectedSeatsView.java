package com.praxis.movieviewer.seatselector.selectedseats;

import android.content.Context;

public interface SelectedSeatsView {

  void addSeat(SelectedSeatView seatView);

  void removeSeat(SelectedSeatView seatView);

  Context getContext();

  void clearSelection();

}
