package com.praxis.movieviewer.seatselector.seatmap;

import android.view.View;

import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItem;

public interface SeatView {

  enum SeatStatus {
    NONE,
    AVAILABLE,
    SELECTED,
    RESERVED
  }

  void setSeatInfo(SeatMapItem seatMapItem, SeatSelectionListener seatSelectionListener);

  View getView();

  boolean isSeatSelected();

  void selectSeat();

  interface SeatSelectionListener {

    boolean canSelectSeat();

    void onSelectSeat(SeatMapItem seatMapItem);

    void onDeselectSeat(SeatMapItem seatMapItem);

//    void showMaxSelectionError

  }

}
