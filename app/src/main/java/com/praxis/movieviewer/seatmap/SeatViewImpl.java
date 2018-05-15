package com.praxis.movieviewer.seatmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatmap.models.SeatInfo;

import butterknife.ButterKnife;

public class SeatViewImpl extends LinearLayout implements SeatView {

//  @BindView(R.id.tvSeatName)
//  TextView tvSeatName;

  public SeatViewImpl(Context context) {
    super(context);
    init();
  }

  public SeatViewImpl(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SeatViewImpl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SeatViewImpl(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_seat, this, true);
    ButterKnife.bind(this);
  }

  @Override
  public void setSeatInfo(SeatInfo seatInfo) {
//    tvSeatName.setText(seatInfo.getName());
  }

  private void processColor() {

  }

  @Override
  public void setStatus(SeatStatus status) {
    if(SeatStatus.RESERVED == status) {
      setEnabled(false);
      setSelected(true);
    } else if(SeatStatus.SELECTED == status) {
      setEnabled(true);
      setSelected(true);
    } else if(SeatStatus.AVAILABLE == status) {
      setEnabled(true);
      setSelected(false);
    } else {
      setEnabled(false);
      setSelected(false);
    }
//    switch(status) {
//      case RESERVED:
//        setEnabled(false);
//        setSelected(true);
//        break;
//      case SELECTED:
//        setEnabled(true);
//        setSelected(true);
//        break;
//      case AVAILABLE:
//        setEnabled(true);
//        setSelected(false);
//        break;
//      case NONE:
//        setEnabled(false);
//        setSelected(false);
//      default:
//        break;
//    }
  }
}
