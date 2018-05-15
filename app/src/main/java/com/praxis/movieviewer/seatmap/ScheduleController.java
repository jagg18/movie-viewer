package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.Cinema;
import com.praxis.movieviewer.seatmap.models.MovieDate;
import com.praxis.movieviewer.seatmap.models.Time;

import java.util.List;

public interface ScheduleController {

  List<MovieDate> getDates();

  List<Cinema> getCinemasForDate(MovieDate movieDate);

  List<Time> getTimesForCinema(Cinema cinema);

}
