package com.praxis.movieviewer.seatselector.seatmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatCustomView extends LinearLayout implements SeatView, View.OnClickListener {

  @Nullable
  @BindView(R.id.vSeat)
  View vSeat;

  private int width;

  private SeatCustomViewPresenter seatCustomViewPresenter;

  public SeatCustomView(Context context) {
    super(context);
    init();
  }

  public SeatCustomView(Context context, int width) {
    super(context);
    init();
    setWidth(width);
  }

  private void setWidth(int width) {
    setLayoutParams(new LayoutParams(width, width));
  }

  public SeatCustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SeatCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SeatCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_seat, this, true);
    ButterKnife.bind(this);

    setOnClickListener(this);
  }

  @Override
  public void setSeatInfo(SeatMapItem seatMapItem, SeatSelectionListener seatSelectionListener) {
    seatCustomViewPresenter = new SeatCustomViewPresenter(this, seatMapItem, seatSelectionListener);
  }

  public void setStatus(SeatStatus status) {
    if(SeatStatus.RESERVED == status) {
      vSeat.setEnabled(false);
      vSeat.setSelected(true);
    } else if(SeatStatus.SELECTED == status) {
      vSeat.setEnabled(true);
      vSeat.setSelected(true);
    } else if(SeatStatus.AVAILABLE == status) {
      vSeat.setEnabled(true);
      vSeat.setSelected(false);
    } else {
      vSeat.setEnabled(false);
      vSeat.setSelected(false);
    }
  }

  @Override
  public View getView() {
    return this;
  }

  @Override
  public void onClick(View view) {
    seatCustomViewPresenter.onClickSeat();
  }

  @Override
  public void selectSeat() {
    setSelected(!isSeatSelected());
  }

  @Override
  public boolean isSeatSelected() {
    return isSelected();
  }
}
