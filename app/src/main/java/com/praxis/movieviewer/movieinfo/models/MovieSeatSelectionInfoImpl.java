package com.praxis.movieviewer.movieinfo.models;

public class MovieSeatSelectionInfoImpl implements MovieSeatSelectionInfo {

  private String movieId;

  private String theater;

  public MovieSeatSelectionInfoImpl(String movieId, String theater) {
    this.movieId = movieId;
    this.theater = theater;
  }

  @Override
  public String getMovieId() {
    return movieId;
  }

  @Override
  public String getTheatre() {
    return theater;
  }
}
