package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.Cinema;
import com.praxis.movieviewer.seatmap.models.MovieDate;
import com.praxis.movieviewer.seatmap.models.SeatInfo;
import com.praxis.movieviewer.seatmap.models.Time;

public interface SeatSelectionPresenter {

  void onResume();

  void onDestroy();

  void getSeatMap();

  void selectSeat(SeatInfo seatInfo);

  void onSelectDate(MovieDate date);

  void onSelectCinema(Cinema cinema);

  void onSelectTime(Time time);

}
