package com.praxis.movieviewer.seatselector.seatmap.models;

import java.util.List;

public class SeatMapRowModel {

  private String rowName;

  private List<SeatMapItem> seatMapItems;

  public SeatMapRowModel(String rowName, List<SeatMapItem> seatMapItems) {
    this.rowName = rowName;
    this.seatMapItems = seatMapItems;
  }

  public String getRowName() {
    return rowName;
  }

  public List<SeatMapItem> getSeatMapItems() {
    return seatMapItems;
  }
}
