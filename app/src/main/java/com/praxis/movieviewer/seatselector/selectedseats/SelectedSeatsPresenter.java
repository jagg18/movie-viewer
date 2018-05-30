package com.praxis.movieviewer.seatselector.selectedseats;

import com.praxis.movieviewer.seatselector.models.SeatInfo;

import java.util.List;

public interface SelectedSeatsPresenter {

  void selectSeat(SeatInfo seatInfo);

  List<SeatInfo> getSelectedSeats();

  void onClear();

}
