package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.SeatInfo;

public interface SeatView {

  enum SeatStatus {
    NONE,
    AVAILABLE,
    SELECTED,
    RESERVED
  }

  void setSeatInfo(SeatInfo seatInfo);

  void setStatus(SeatStatus status);

}
