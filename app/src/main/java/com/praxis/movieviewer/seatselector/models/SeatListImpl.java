package com.praxis.movieviewer.seatselector.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeatListImpl implements SeatList {

  @SerializedName("seats")
  private List<String> seats;

  @SerializedName("seat_count")
  private int seatCount;

  @Override
  public List<String> getSeats() {
    return seats;
  }
}
