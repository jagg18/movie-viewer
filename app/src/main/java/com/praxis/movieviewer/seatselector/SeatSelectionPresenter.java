package com.praxis.movieviewer.seatselector;

import com.praxis.movieviewer.seatselector.models.Cinema;
import com.praxis.movieviewer.seatselector.models.MovieDate;
import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.models.Time;

import java.util.List;

public interface SeatSelectionPresenter {

  void onResume();

  void onDestroy();

  void onSelectDate(MovieDate date);

  void onSelectCinema(Cinema cinema);

  void onSelectTime(Time time);

  void onSeatsSelected(List<SeatInfo> selectedSeatsList);

  void displaySeats();

}
