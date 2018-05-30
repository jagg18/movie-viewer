package com.praxis.movieviewer.seatselector.managers;

import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.models.SeatInfoImpl;
import com.praxis.movieviewer.seatselector.models.SeatMap;
import com.praxis.movieviewer.seatselector.models.SeatMapRow;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItem;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapItemImpl;
import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatMapControllerImpl implements SeatMapController {

  private SeatMap seatMap;
  private TicketController ticketController;

  private List<SeatMapRowModel> seatMapRowModels;
  private Map<String, SeatInfo> seatInfoData;
  private List<String> availableSeatNames;

  public SeatMapControllerImpl(SeatMap seatMap, TicketController ticketController) {
    this.seatMap = seatMap;
    this.ticketController = ticketController;

    seatMapRowModels = new ArrayList<>();
    seatInfoData = new HashMap<>();

    initialize();
  }

  @Override
  public void initialize() {
    getAvailableSeatNames();
    createSeatMapData();
  }

  private String getRowName(SeatMapRow seatMapRow) {
    if(seatMapRow != null && !seatMapRow.isEmpty()) {
      // return first letter of seat names
      return String.valueOf(seatMapRow.get(0).charAt(0));
    }
    return "";
  }

  private void createSeatMapData() {
    seatMapRowModels.clear();
    seatInfoData.clear();
    String rowName;

    for(SeatMapRow seatMapRow : seatMap.getSeatMap()
            ) {

      // refresh row list
      List<SeatMapItem> seatMapItems = new ArrayList<>();
      // assign row name
      rowName = getRowName(seatMapRow);

      // traverse each seat map row to get seat names
      for(String seatName : seatMapRow
              ) {

        SeatInfo seatInfo = createSeatInfoFrom(seatName);
        seatInfoData.put(seatName, seatInfo);

        SeatMapItem.SeatType seatType = isValidSeat(seatName) ? SeatMapItem.SeatType.REGULAR : SeatMapItem.SeatType.SPACE;
        SeatMapItem seatMapItem = new SeatMapItemImpl(seatInfo, seatType);

        seatMapItems.add(seatMapItem);
      }

      // record seatmap
      SeatMapRowModel seatMapRowModel = new SeatMapRowModel(rowName, seatMapItems);
      seatMapRowModels.add(seatMapRowModel);
    }
  }

  private SeatInfo createSeatInfoFrom(String seatName) {
    double seatPrice = ticketController.getTicketPriceForSeat(seatName);
    // temp logic for determining if seat is Available or Reserved
    SeatInfo.SeatStatus seatStatus = isSeatAvailable(seatName) ? SeatInfo.SeatStatus.AVAILABLE : SeatInfo.SeatStatus.RESERVED;

    return new SeatInfoImpl(seatName, seatPrice, seatStatus);
  }

  private void getAvailableSeatNames() {
    availableSeatNames = seatMap.getAvailableSeats();
  }

  private boolean isSeatAvailable(String name) {
    return availableSeatNames.contains(name);
  }

  private boolean isValidSeat(String name) {
    return !name.contains("(") && !name.contains(")");
  }

  @Override
  public List<SeatMapRowModel> getSeatMapData() {
    return seatMapRowModels;
  }
}
