package com.praxis.movieviewer.seatselector;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.seatselector.models.Cinema;
import com.praxis.movieviewer.seatselector.models.MovieDate;
import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.models.Time;
import com.praxis.movieviewer.seatselector.seatmap.SeatSelectorView;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatSelectionActivity extends AppCompatActivity implements SeatSelectionView {

  public static final String EXTRA_MOVIE_SEAT_MAP_INFO = "com.praxis.movieviewer.seatmap.MOVIE_SEAT_MAP_INFO";

  @BindView(R.id.tvTheaterName)
  TextView tvTheaterName;

  @BindView(R.id.vSelectorDate)
  Spinner vSelectorDate;

  @BindView(R.id.vSelectorCinema)
  Spinner vSelectorCinema;

  @BindView(R.id.vSelectorTime)
  Spinner vSelectorTime;

  @BindView(R.id.tvTotalPrice)
  TextView tvTotalPrice;

  @Nullable
  @BindView(R.id.vSeatSelectorView)
  SeatSelectorView vSeatSelectorView;

  private SeatSelectionPresenter seatSelectionPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_seat_selection);

    ButterKnife.bind(this);

    // get movie info
    MovieSeatSelectionInfo movieSeatSelectionInfo = (MovieSeatSelectionInfo) getIntent().getSerializableExtra(EXTRA_MOVIE_SEAT_MAP_INFO);

    seatSelectionPresenter = new SeatSelectionPresenterImpl(this, movieSeatSelectionInfo);

    vSelectorDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        vSelectorCinema.setAdapter(null);
        vSelectorTime.setAdapter(null);

        try {
          MovieDate movieDate = (MovieDate) adapterView.getItemAtPosition(i);
          seatSelectionPresenter.onSelectDate(movieDate);
        } catch(Exception e) {

        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });

    vSelectorCinema.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        vSelectorTime.setAdapter(null);

        Cinema cinema = (Cinema) adapterView.getItemAtPosition(i);
        seatSelectionPresenter.onSelectCinema(cinema);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });

    vSelectorTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Time time = (Time) adapterView.getItemAtPosition(i);
        seatSelectionPresenter.onSelectTime(time);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });

    vSeatSelectorView.setSeatSelectorListener(new SeatSelectorView.SeatSelectorListener() {
      @Override
      public void onUpdateSeatSelection(List<SeatInfo> selectedSeats) {
        seatSelectionPresenter.onSeatsSelected(selectedSeats);
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    seatSelectionPresenter.onResume();
  }

  @Override
  protected void onDestroy() {
    seatSelectionPresenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public void showProgress() {

  }

  @Override
  public void hideProgress() {

  }

  @Override
  public void setMovieSeatSelectionInfo(MovieSeatSelectionInfo movieSeatSelectionInfo) {
    tvTheaterName.setText(movieSeatSelectionInfo.getTheatre());
  }

  @Override
  public void setTotalPrice(String totalPrice) {
    tvTotalPrice.setText(totalPrice);
  }

  @Override
  public Context getContext() {
    return this;
  }

  @Override
  public void setDates(List<MovieDate> dates) {
    MovieDatesAdapter datesAdapter = new MovieDatesAdapter(this, R.layout.item_spinner_schedule, dates);
    datesAdapter.setDropDownViewResource(R.layout.item_dropdown_schedule);
    vSelectorDate.setAdapter(datesAdapter);
  }

  @Override
  public void setCinemas(List<Cinema> cinemas) {
    CinemasAdapter cinemasAdapter = new CinemasAdapter(this, R.layout.item_spinner_schedule, cinemas);
    cinemasAdapter.setDropDownViewResource(R.layout.item_dropdown_schedule);
    vSelectorCinema.setAdapter(cinemasAdapter);
  }

  @Override
  public void setTimes(List<Time> times) {
    TimesAdapter timesAdapter = new TimesAdapter(this, R.layout.item_spinner_schedule, times);
    timesAdapter.setDropDownViewResource(R.layout.item_dropdown_schedule);
    vSelectorTime.setAdapter(timesAdapter);
  }

  @Override
  public void displaySeats(List<SeatMapRowModel> seatMap) {
    vSeatSelectorView.displaySeats(seatMap);
  }
}
