package com.praxis.movieviewer.seatselector.managers;

import com.praxis.movieviewer.seatselector.models.Cinema;
import com.praxis.movieviewer.seatselector.models.MovieDate;
import com.praxis.movieviewer.seatselector.models.Time;

import java.util.List;

public interface ScheduleController {

  List<MovieDate> getDates();

  List<Cinema> getCinemasForDate(MovieDate movieDate);

  List<Time> getTimesForCinema(Cinema cinema);

  double getSeatPriceForTime(Time time);

}
