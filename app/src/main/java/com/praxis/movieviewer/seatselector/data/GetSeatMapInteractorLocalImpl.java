package com.praxis.movieviewer.seatselector.data;

import android.content.Context;

import com.google.gson.Gson;
import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.models.SeatMapImpl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetSeatMapInteractorLocalImpl implements GetSeatMapInteractor {

  private Context mContext;

  public GetSeatMapInteractorLocalImpl(Context context) {
    mContext = context;
  }

  @Override
  public void getSeatMap(OnFinishedListener listener) {
    InputStream raw = mContext.getResources().openRawResource(R.raw.seatmap);
    Reader rd = new InputStreamReader(raw);

    Gson gson = new Gson();

    listener.onFinished(gson.fromJson(rd, SeatMapImpl.class));
  }

}
