package com.praxis.movieviewer.seatmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.praxis.movieviewer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedSeatsViewImpl extends LinearLayout implements SelectedSeatsView {

  private final int NO_SEATS_MAX = 10;
  private final int NO_SEATS_PER_ROW = 5;

  @BindView(R.id.vSeatList)
  FlexboxLayout vSeatList;

  public SelectedSeatsViewImpl(Context context) {
    super(context);
    init();
  }

  public SelectedSeatsViewImpl(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SelectedSeatsViewImpl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SelectedSeatsViewImpl(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_selected_seats, this, true);
    ButterKnife.bind(this);
  }

  @Override
  public void addSeat(SelectedSeatView seatView) {
    vSeatList.addView((View) seatView);
  }

  @Override
  public void removeSeat(SelectedSeatView seatView) {
    vSeatList.removeView((View) seatView);
  }

  @Override
  public int getMaxNoOfSeats() {
    return NO_SEATS_MAX;
  }

  @Override
  public void showMaxSeatsError() {
    Toast.makeText(getContext(), "You can only select up to 10 seats.", Toast.LENGTH_LONG).show();
  }
}
