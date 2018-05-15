package com.praxis.movieviewer.seatmap;

import android.content.Context;

import com.google.gson.Gson;
import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatmap.models.ScheduleImpl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetScheduleInteractorLocalImpl implements GetScheduleInteractor {

  private Context mContext;

  public GetScheduleInteractorLocalImpl(Context context) {
    mContext = context;
  }

  @Override
  public void getSchedule(OnFinishedListener listener) {
    InputStream raw = mContext.getResources().openRawResource(R.raw.schedule);
    Reader rd = new InputStreamReader(raw);

    Gson gson = new Gson();

    listener.onFinished(gson.fromJson(rd, ScheduleImpl.class));
  }

}
