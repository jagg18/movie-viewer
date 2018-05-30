package com.praxis.movieviewer.seatselector.selectedseats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.models.SeatInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedSeatCustomView extends LinearLayout implements SelectedSeatView {

  @BindView(R.id.tvSeatName)
  TextView tvSeatName;

  public SelectedSeatCustomView(Context context) {
    super(context);
    init();
  }

  public SelectedSeatCustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SelectedSeatCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SelectedSeatCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_selected_seat, this, true);
    ButterKnife.bind(this);
  }

  @Override
  public void setSeatInfo(SeatInfo seatInfo) {
    tvSeatName.setText(seatInfo.getName());
  }


}
