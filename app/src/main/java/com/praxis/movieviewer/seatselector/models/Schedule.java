package com.praxis.movieviewer.seatselector.models;

import java.util.List;

public interface Schedule {

  List<MovieDate> getDates();

  List<CinemaGroup> getCinemaGroups();

  List<TimeGroup> getTimeGroups();

}
