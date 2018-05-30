package com.praxis.movieviewer.seatselector.seatmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItem;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatRowView extends LinearLayout {

  @BindView(R.id.tvRowName1)
  TextView tvRowName1;

  @BindView(R.id.tvRowName2)
  TextView tvRowName2;

  @BindView(R.id.llSeatRow)
  LinearLayout llSeatRow;

  private int layoutWidth;

  private SeatRowPresenter seatRowPresenter;

  public SeatRowView(Context context) {
    super(context);
    init();
  }

  public SeatRowView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SeatRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SeatRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_seat_row, this, true);
    ButterKnife.bind(this);

    llSeatRow.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        layoutWidth = llSeatRow.getWidth();
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
          llSeatRow.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
          llSeatRow.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
      }
    });

    if(llSeatRow != null) {
      getViewWidth();
    }
  }

  private void getViewWidth() {
    llSeatRow.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        layoutWidth = llSeatRow.getWidth();

        seatRowPresenter.plotSeats();
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
          llSeatRow.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
          llSeatRow.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
      }
    });
  }

  public void setRow(SeatMapRowModel seatMapRow, SeatView.SeatSelectionListener seatSelectionListener) {
    seatRowPresenter = new SeatRowPresenter(this, seatMapRow, seatSelectionListener);
  }

  public void displayRow(String rowName, List<SeatMapItem> seatMapItems) {
    tvRowName1.setText(rowName);
    tvRowName2.setText(rowName);


    drawSeats(seatMapItems);
  }

  private void drawSeats(List<SeatMapItem> seatMapItems) {
    int seatWidth = layoutWidth / seatMapItems.size();
    for(SeatMapItem seatMapItem : seatMapItems) {
      SeatView seatView = createSeatView(seatMapItem, seatWidth);
      llSeatRow.addView(seatView.getView());
    }
  }

  private SeatView createSeatView(SeatMapItem seatMapItem, int seatWidth) {
    SeatView seatView = new SeatCustomView(getContext(), seatWidth);
    seatView.setSeatInfo(seatMapItem, seatRowPresenter.getSeatSelectionListener());
    return seatView;
  }
}
