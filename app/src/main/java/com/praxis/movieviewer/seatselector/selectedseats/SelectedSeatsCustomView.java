package com.praxis.movieviewer.seatselector.selectedseats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;
import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.models.SeatInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedSeatsCustomView extends LinearLayout implements SelectedSeatsView {

  private final int NO_SEATS_PER_ROW = 5;

  @BindView(R.id.vSeatList)
  FlexboxLayout vSeatList;

  SelectedSeatsPresenter selectedSeatsPresenter;

  public SelectedSeatsCustomView(Context context) {
    super(context);
    init();
  }

  public SelectedSeatsCustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SelectedSeatsCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SelectedSeatsCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_selected_seats, this, true);
    ButterKnife.bind(this);

    selectedSeatsPresenter = new SelectedSeatsPresenterImpl(this);
  }

  public void selectSeat(SeatInfo seatInfo) {
    selectedSeatsPresenter.selectSeat(seatInfo);
  }

  public void deselectSeat(SeatInfo seatInfo) {
    selectSeat(seatInfo);
  }

  @Override
  public void addSeat(SelectedSeatView seatView) {
    View view = (View) seatView;

    FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
    view.setLayoutParams(lp);

    vSeatList.addView(view);

    relayoutList();
  }

  @Override
  public void removeSeat(SelectedSeatView seatView) {
    vSeatList.removeView((View) seatView);
  }

  private void relayoutList() {
    for(int i = 0; i < vSeatList.getChildCount(); i++) {
      View v = vSeatList.getChildAt(i);
      FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) v.getLayoutParams();
      if(i % NO_SEATS_PER_ROW == 0) {
        lp.setWrapBefore(true);
      } else {
        lp.setWrapBefore(false);
      }
      v.setLayoutParams(lp);
    }
    requestLayout();
  }

  public List<SeatInfo> getSelectedSeats() {
    return selectedSeatsPresenter.getSelectedSeats();
  }

  @Override
  public void clearSelection() {
    vSeatList.removeAllViews();
  }

  public void clear() {
    selectedSeatsPresenter.onClear();
  }
}
