package com.praxis.movieviewer.seatselector.seatmap;

import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;

public class SeatRowPresenter {

  private SeatRowView seatRowView;
  private SeatMapRowModel seatMapRow;

  private SeatView.SeatSelectionListener seatSelectionListener;

  public SeatRowPresenter(SeatRowView seatRowView, SeatMapRowModel seatMapRow, SeatView.SeatSelectionListener seatSelectionListener) {
    this.seatRowView = seatRowView;
    this.seatMapRow = seatMapRow;
    this.seatSelectionListener = seatSelectionListener;
  }

  public void plotSeats() {
    seatRowView.displayRow(seatMapRow.getRowName(), seatMapRow.getSeatMapItems());
  }

  public SeatView.SeatSelectionListener getSeatSelectionListener() {
    return seatSelectionListener;
  }
}
