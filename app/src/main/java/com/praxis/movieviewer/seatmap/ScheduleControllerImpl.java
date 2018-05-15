package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.Cinema;
import com.praxis.movieviewer.seatmap.models.CinemaGroup;
import com.praxis.movieviewer.seatmap.models.MovieDate;
import com.praxis.movieviewer.seatmap.models.Schedule;
import com.praxis.movieviewer.seatmap.models.Time;
import com.praxis.movieviewer.seatmap.models.TimeGroup;

import java.util.ArrayList;
import java.util.List;

public class ScheduleControllerImpl implements ScheduleController {

  private Schedule schedule;

  public ScheduleControllerImpl(Schedule schedule) {
    this.schedule = schedule;
  }

  @Override
  public List<MovieDate> getDates() {
    return schedule.getDates();
  }

  @Override
  public List<Cinema> getCinemasForDate(MovieDate movieDate) {
    for(CinemaGroup cinemaGroup : schedule.getCinemaGroups()
        ) {
      String movieId = movieDate.getId();

      // invalid movie id
      if(movieId == null || movieId.isEmpty()) {
        return null;
      }

      if(movieId.equals(cinemaGroup.getParent())) {
        return cinemaGroup.getCinemas();
      }
    }
    return new ArrayList<>();
  }

  @Override
  public List<Time> getTimesForCinema(Cinema cinema) {
    for(TimeGroup timeGroup : schedule.getTimeGroups()
            ) {
      String cinemaId = cinema.getId();

      // invalid movie id
      if(cinemaId == null || cinemaId.isEmpty()) {
        return null;
      }

      if(cinemaId.equals(timeGroup.getParent())) {
        return timeGroup.getTimes();
      }
    }
    return new ArrayList<>();
  }
}
