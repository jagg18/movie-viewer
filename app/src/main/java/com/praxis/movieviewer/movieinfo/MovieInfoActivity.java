package com.praxis.movieviewer.movieinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.praxis.movieviewer.R;
import com.praxis.movieviewer.movieinfo.models.MovieInfo;
import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.seatmap.SeatSelectionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieInfoActivity extends AppCompatActivity implements MovieInfoView {

  @BindView(R.id.ivMoviePosterLandscape)
  ImageView ivMoviePosterLandscape;

  @BindView(R.id.ivMoviePoster)
  ImageView ivMoviePoster;

  @BindView(R.id.tvName)
  TextView tvName;

  @BindView(R.id.tvGenre)
  TextView tvGenre;

  @BindView(R.id.tvAdvisoryRating)
  TextView tvAdvisoryRating;

  @BindView(R.id.tvDuration)
  TextView tvDuration;

  @BindView(R.id.tvReleaseDate)
  TextView tvReleaseDate;

  @BindView(R.id.tvSynopsis)
  TextView tvSynopsis;

  @BindView(R.id.tvCast)
  TextView tvCast;

  private MovieInfoPresenter movieInfoPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_info);

    ButterKnife.bind(this);

    movieInfoPresenter = new MovieInfoPresenterImpl(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    movieInfoPresenter.onResume();
  }

  @Override
  protected void onDestroy() {
    movieInfoPresenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public void showProgress() {

  }

  @Override
  public void hideProgress() {

  }

  @Override
  public void setMovieInfo(MovieInfo movieInfo) {
    if(movieInfo == null) {
      return;
    }

    // set movie info
    Glide.with(this).load(movieInfo.getPosterLandscapeUrl()).into(ivMoviePosterLandscape);
    Glide.with(this).load(movieInfo.getPosterUrl()).into(ivMoviePoster);

    tvName.setText(movieInfo.getTitle());
    tvGenre.setText(movieInfo.getGenre());
    tvAdvisoryRating.setText(movieInfo.getAdvisoryRating());
    tvDuration.setText(movieInfo.getDuration());
    tvReleaseDate.setText(movieInfo.getReleaseDate());
    tvSynopsis.setText(movieInfo.getSynopsis());
    tvCast.setText(movieInfo.getCast());
  }

  @OnClick(R.id.btnViewSeatMap)
  void viewSeatMap() {
    movieInfoPresenter.onViewSeatMap();
  }

  @Override
  public void openSeatMap(MovieSeatSelectionInfo movieSeatSelectionInfo) {
    Intent seatMapIntent = new Intent(this, SeatSelectionActivity.class);
    seatMapIntent.putExtra(SeatSelectionActivity.EXTRA_MOVIE_SEAT_MAP_INFO, movieSeatSelectionInfo);
    startActivity(seatMapIntent);
  }

  @Override
  public Context getContext() {
    return this;
  }
}
