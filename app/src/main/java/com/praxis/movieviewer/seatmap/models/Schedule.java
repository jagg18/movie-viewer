package com.praxis.movieviewer.seatmap.models;

import java.util.List;

public interface Schedule {

  List<MovieDate> getDates();

  List<CinemaGroup> getCinemaGroups();

  List<TimeGroup> getTimeGroups();

}
