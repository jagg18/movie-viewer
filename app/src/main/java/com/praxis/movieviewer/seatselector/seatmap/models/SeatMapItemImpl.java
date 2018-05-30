package com.praxis.movieviewer.seatselector.seatmap.models;

import com.praxis.movieviewer.seatselector.models.SeatInfo;

public class SeatMapItemImpl implements SeatMapItem {

  private SeatInfo seatInfo;

  private SeatMapItem.SeatType seatType;

  public SeatMapItemImpl(SeatInfo seatInfo, SeatType seatType) {
    this.seatInfo = seatInfo;
    this.seatType = seatType;
  }

  @Override
  public SeatInfo getSeatInfo() {
    return seatInfo;
  }

  @Override
  public SeatType getSeatType() {
    return seatType;
  }
}
