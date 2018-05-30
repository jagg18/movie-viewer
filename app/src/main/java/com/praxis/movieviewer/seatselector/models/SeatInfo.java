package com.praxis.movieviewer.seatselector.models;

public interface SeatInfo {

  enum SeatStatus {
    AVAILABLE,
    RESERVED
  }

  String getName();

  double getPrice();

  SeatStatus getSeatStatus();

}
