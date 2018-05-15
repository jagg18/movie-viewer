package com.praxis.movieviewer.seatmap.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ScheduleImpl implements Schedule {

  @SerializedName("dates")
  private List<MovieDateImpl> dates;

  @SerializedName("cinemas")
  private List<CinemaGroup> cinemas;

  @SerializedName("times")
  private List<TimeGroup> times;

  public ScheduleImpl() {

  }

  @Override
  public List<MovieDate> getDates() {
    List<MovieDate> movieDates = new ArrayList<>();
    for(MovieDate movieDate : dates
        ) {
      movieDates.add(movieDate);
    }
    return movieDates;
  }

  @Override
  public List<CinemaGroup> getCinemaGroups() {
    return cinemas;
  }

  @Override
  public List<TimeGroup> getTimeGroups() {
    return times;
  }
}
