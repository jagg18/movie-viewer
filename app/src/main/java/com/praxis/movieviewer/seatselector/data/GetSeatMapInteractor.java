package com.praxis.movieviewer.seatselector.data;

import com.praxis.movieviewer.seatselector.models.SeatMap;

public interface GetSeatMapInteractor {

  interface OnFinishedListener {
    void onFinished(SeatMap seatMap);
  }

  void getSeatMap(OnFinishedListener listener);
}
