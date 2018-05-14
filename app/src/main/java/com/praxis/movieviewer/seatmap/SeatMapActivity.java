package com.praxis.movieviewer.seatmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.movieinfo.models.MovieSeatMapInfo;
import com.praxis.movieviewer.seatmap.models.SeatInfoImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeatMapActivity extends AppCompatActivity implements SeatMapView {

  public static final String EXTRA_MOVIE_SEAT_MAP_INFO = "com.praxis.movieviewer.seatmap.MOVIE_SEAT_MAP_INFO";

  @BindView(R.id.tvTheaterName)
  TextView tvTheaterName;

  @BindView(R.id.tvTotalPrice)
  TextView tvTotalPrice;

  @BindView(R.id.vSelectedSeats)
  SelectedSeatsView selectedSeatsView;

  private SeatMapPresenter seatMapPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_seat_map);

    ButterKnife.bind(this);

    // get movie info
    MovieSeatMapInfo movieSeatMapInfo = (MovieSeatMapInfo) getIntent().getSerializableExtra(EXTRA_MOVIE_SEAT_MAP_INFO);

    seatMapPresenter = new SeatMapPresenterImpl(this, movieSeatMapInfo);
  }

  @OnClick(R.id.tvLabelTotalPrice)
  void addSeat() {
    seatMapPresenter.selectSeat(new SeatInfoImpl("B4", 210.12));
  }

  @OnClick(R.id.tvTheaterName)
  void addSeat1() {
    seatMapPresenter.selectSeat(new SeatInfoImpl("C7", 120.44));
  }

  @Override
  public void setMovieSeatMapInfo(MovieSeatMapInfo movieSeatMapInfo) {
    tvTheaterName.setText(movieSeatMapInfo.getTheatre());
  }

  @Override
  public SelectedSeatsView getSelectedSeatsView() {
    return selectedSeatsView;
  }

  @Override
  public void setTotalPrice(String totalPrice) {
    tvTotalPrice.setText(totalPrice);
  }
}
