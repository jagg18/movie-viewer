package com.praxis.movieviewer.movieinfo.models;

import java.io.Serializable;

public interface MovieInfo extends Serializable {

  String getMovieId();

  String getTitle();

  String getGenre();

  String getAdvisoryRating();

  String getDuration();

  String getReleaseDate();

  String getSynopsis();

  String getCast();

  String getPosterLandscapeUrl();

  String getPosterUrl();

  String getTheater();

}
