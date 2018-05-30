package com.praxis.movieviewer.seatselector.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeatMapImpl implements SeatMap {

  @SerializedName("seatmap")
  private List<SeatMapRow> seatMap;

  @SerializedName("available")
  private SeatListImpl available;

  @Override
  public List<SeatMapRow> getSeatMap() {
    return seatMap;
  }

  @Override
  public List<String> getAvailableSeats() {
    return available.getSeats();
  }
}
