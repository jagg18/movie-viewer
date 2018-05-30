package com.praxis.movieviewer.seatselector.seatmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.praxis.movieviewer.R;
import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItem;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;
import com.praxis.movieviewer.seatselector.selectedseats.SelectedSeatsCustomView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatSelectorView extends RelativeLayout implements SeatView.SeatSelectionListener {

  private final int NO_SEATS_MAX = 10;

  @Nullable
  @BindView(R.id.vSeats)
  LinearLayout vSeats;

  @Nullable
  @BindView(R.id.vSelectedSeats)
  SelectedSeatsCustomView vSelectedSeats;

  @Nullable
  @BindView(R.id.vSeatLegendAvailable)
  SeatCustomView vSeatLegendAvailable;

  @Nullable
  @BindView(R.id.vSeatLegendReserved)
  SeatCustomView vSeatLegendReserved;

  @Nullable
  @BindView(R.id.vSeatLegendSelected)
  SeatCustomView vSeatLegendSelected;

  private SeatSelectorListener seatSelectorListener;

  public SeatSelectorView(Context context) {
    super(context);
    init();
  }

  public SeatSelectorView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SeatSelectorView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public SeatSelectorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_seat_selector, this, true);
    ButterKnife.bind(this);

    vSeatLegendAvailable.setStatus(SeatView.SeatStatus.AVAILABLE);
    vSeatLegendReserved.setStatus(SeatView.SeatStatus.RESERVED);
    vSeatLegendSelected.setStatus(SeatView.SeatStatus.SELECTED);
  }

  public void displaySeats(List<SeatMapRowModel> seatMap) {
    vSeats.removeAllViews();
    for(SeatMapRowModel seatRow : seatMap) {
      SeatRowView seatRowView = createSeatRow(seatRow
      );
      vSeats.addView(seatRowView);
    }

    vSelectedSeats.clear();
  }

  private SeatRowView createSeatRow(SeatMapRowModel seatRow) {
    SeatRowView seatRowView = new SeatRowView(getContext());
    seatRowView.setRow(seatRow, this);
    return seatRowView;
  }

  @Override
  public boolean canSelectSeat() {
    boolean canSelectSeat = vSelectedSeats.getSelectedSeats().size() < NO_SEATS_MAX;

    if(!canSelectSeat) {
      showMaxSeatsError();
    }

    return canSelectSeat;
  }

  @Override
  public void onSelectSeat(SeatMapItem seatMapItem) {
    vSelectedSeats.selectSeat(seatMapItem.getSeatInfo());

    updateSeatSelection();
  }

  @Override
  public void onDeselectSeat(SeatMapItem seatMapItem) {
    vSelectedSeats.deselectSeat(seatMapItem.getSeatInfo());

    updateSeatSelection();
  }

  private void updateSeatSelection() {
    if(seatSelectorListener != null) {
      seatSelectorListener.onUpdateSeatSelection(vSelectedSeats.getSelectedSeats());
    }
  }


  private void showMaxSeatsError() {
    Toast.makeText(getContext(), "You can only select up to 10 seats.", Toast.LENGTH_LONG).show();
  }

  public interface SeatSelectorListener {
    void onUpdateSeatSelection(List<SeatInfo> selectedSeats);
  }

  public void setSeatSelectorListener(SeatSelectorListener seatSelectorListener) {
    this.seatSelectorListener = seatSelectorListener;
  }
}
