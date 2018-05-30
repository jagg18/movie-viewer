package com.praxis.movieviewer.seatselector.seatmap.models;

import com.praxis.movieviewer.seatselector.models.SeatInfo;

public interface SeatMapItem {

  public enum SeatType {
    REGULAR,
    SPACE
  }

  SeatInfo getSeatInfo();

  SeatType getSeatType();

}
