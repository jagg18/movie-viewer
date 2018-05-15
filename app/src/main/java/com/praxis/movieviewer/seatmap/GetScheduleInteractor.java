package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.seatmap.models.Schedule;

public interface GetScheduleInteractor {

  interface OnFinishedListener {
    void onFinished(Schedule schedule);
  }

  void getSchedule(OnFinishedListener listener);
}
