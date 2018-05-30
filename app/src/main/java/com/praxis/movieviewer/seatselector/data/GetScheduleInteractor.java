package com.praxis.movieviewer.seatselector.data;

import com.praxis.movieviewer.seatselector.models.Schedule;

public interface GetScheduleInteractor {

  interface OnFinishedListener {
    void onFinished(Schedule schedule);
  }

  void getSchedule(OnFinishedListener listener);
}
