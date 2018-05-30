package com.praxis.movieviewer.seatselector.seatmap;

import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItem;

public class SeatCustomViewPresenter {

  private SeatCustomView seatCustomView;
  private SeatMapItem seatMapItem;
  private SeatInfo seatInfo;

  private SeatView.SeatSelectionListener seatSelectionListener;

  public SeatCustomViewPresenter(SeatCustomView seatCustomView, SeatMapItem seatMapItem, SeatView.SeatSelectionListener seatSelectionListener) {
    this.seatCustomView = seatCustomView;
    this.seatMapItem = seatMapItem;
    this.seatInfo = seatMapItem.getSeatInfo();

    this.seatSelectionListener = seatSelectionListener;

    setSeatStatus();
  }

  private void setSeatStatus() {
    //set default
    SeatView.SeatStatus seatStatus = SeatView.SeatStatus.AVAILABLE;

    if(SeatMapItem.SeatType.SPACE == seatMapItem.getSeatType()) {
      seatStatus = SeatView.SeatStatus.NONE;
    } else if(SeatMapItem.SeatType.REGULAR == seatMapItem.getSeatType()) {
      SeatInfo seatInfo = seatMapItem.getSeatInfo();
      if(SeatInfo.SeatStatus.AVAILABLE == seatInfo.getSeatStatus()) {
        seatStatus = SeatView.SeatStatus.AVAILABLE;
      } else if(SeatInfo.SeatStatus.RESERVED == seatInfo.getSeatStatus()) {
        seatStatus = SeatView.SeatStatus.RESERVED;
      }
    }

    seatCustomView.setStatus(seatStatus);
  }

  public void onClickSeat() {
    if(isSeatAvailable() && !seatCustomView.isSeatSelected() && seatSelectionListener.canSelectSeat()) {
      seatCustomView.selectSeat();
      seatSelectionListener.onSelectSeat(seatMapItem);
    } else if(seatCustomView.isSeatSelected()) {
      seatCustomView.selectSeat();
      seatSelectionListener.onDeselectSeat(seatMapItem);
    }
  }

  private boolean isSeatAvailable() {
    return SeatInfo.SeatStatus.AVAILABLE == seatInfo.getSeatStatus();
  }

  public SeatMapItem getData() {
    return seatMapItem;
  }

}
