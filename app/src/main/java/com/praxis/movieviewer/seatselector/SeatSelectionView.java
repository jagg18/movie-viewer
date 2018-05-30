package com.praxis.movieviewer.seatselector;

import android.content.Context;

import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.seatselector.models.Cinema;
import com.praxis.movieviewer.seatselector.models.MovieDate;
import com.praxis.movieviewer.seatselector.models.Time;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;
import com.praxis.movieviewer.seatselector.selectedseats.SelectedSeatsView;

import java.util.List;

public interface SeatSelectionView {

  void showProgress();

  void hideProgress();

  void setMovieSeatSelectionInfo(MovieSeatSelectionInfo movieSeatSelectionInfo);

  void setTotalPrice(String price);

  Context getContext();

  void setDates(List<MovieDate> dates);

  void setCinemas(List<Cinema> cinemas);

  void setTimes(List<Time> times);

  void displaySeats(List<SeatMapRowModel> seatMap);

}
