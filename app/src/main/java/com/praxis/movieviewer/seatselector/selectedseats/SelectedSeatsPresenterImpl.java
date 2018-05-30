package com.praxis.movieviewer.seatselector.selectedseats;

import com.praxis.movieviewer.seatselector.models.SeatInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedSeatsPresenterImpl implements SelectedSeatsPresenter {

  private SelectedSeatsView selectedSeatsView;

  private Map<SeatInfo, SelectedSeatView> selectedSeatMap;

  public SelectedSeatsPresenterImpl(SelectedSeatsView selectedSeatsView) {
    this.selectedSeatsView = selectedSeatsView;

    selectedSeatMap = new HashMap<>();
  }

  @Override
  public void selectSeat(SeatInfo seatInfo) {
//    // check if user can still select seats
//    if(!canAddMoreSeats()) {
//      selectedSeatsView.showMaxSeatsError();
//      return;
//    }

    // if seat is already added, unselect seat
    // else, select seat
    if(canAddSeat(seatInfo)) {
      addSeat(seatInfo);
    } else {
      removeSeat(seatInfo);
    }
  }

//  private boolean canAddMoreSeats() {
//    return selectedSeatMap.size() < selectedSeatsView.getMaxNoOfSeats();
//  }

  private boolean canAddSeat(SeatInfo seatInfo) {
    return !selectedSeatMap.containsKey(seatInfo);
//    return true;
  }

  //  @Override
  public void addSeat(SeatInfo seatInfo) {
    // create selected seat
    SelectedSeatView selectedSeatView = new SelectedSeatCustomView(selectedSeatsView.getContext());
    selectedSeatView.setSeatInfo(seatInfo);

    selectedSeatMap.put(seatInfo, selectedSeatView);
    selectedSeatsView.addSeat(selectedSeatView);
  }

  //  @Override
  public void removeSeat(SeatInfo seatInfo) {
    SelectedSeatView selectedSeatView = selectedSeatMap.get(seatInfo);

    if(selectedSeatView != null) {
      selectedSeatMap.remove(seatInfo);
      selectedSeatsView.removeSeat(selectedSeatView);
    }
  }

  @Override
  public List<SeatInfo> getSelectedSeats() {
    return new ArrayList<>(selectedSeatMap.keySet());
  }

  @Override
  public void onClear() {
    selectedSeatMap.clear();
    selectedSeatsView.clearSelection();
  }
}
