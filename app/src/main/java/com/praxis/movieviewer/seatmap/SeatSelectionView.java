package com.praxis.movieviewer.seatmap;

import android.content.Context;

import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.seatmap.models.Cinema;
import com.praxis.movieviewer.seatmap.models.MovieDate;
import com.praxis.movieviewer.seatmap.models.Time;

import java.util.List;

public interface SeatSelectionView {

  void showProgress();

  void hideProgress();

  void setMovieSeatSelectionInfo(MovieSeatSelectionInfo movieSeatSelectionInfo);

  SelectedSeatsView getSelectedSeatsView();

  void setTotalPrice(String price);

  Context getContext();

  void setDates(List<MovieDate> dates);

  void setCinemas(List<Cinema> cinemas);

  void setTimes(List<Time> times);

}
