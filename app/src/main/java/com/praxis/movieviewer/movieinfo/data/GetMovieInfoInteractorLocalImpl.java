package com.praxis.movieviewer.movieinfo.data;

import android.content.Context;

import com.google.gson.Gson;
import com.praxis.movieviewer.R;
import com.praxis.movieviewer.movieinfo.models.MovieInfoImpl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetMovieInfoInteractorLocalImpl implements GetMovieInfoInteractor {

  private Context mContext;

  public GetMovieInfoInteractorLocalImpl(Context context) {
    mContext = context;
  }

  @Override
  public void getMovieInfo(OnFinishedListener listener) {
    InputStream raw = mContext.getResources().openRawResource(R.raw.movie_info);
    Reader rd = new InputStreamReader(raw);

    Gson gson = new Gson();

    listener.onFinished(gson.fromJson(rd, MovieInfoImpl.class));
  }

}
