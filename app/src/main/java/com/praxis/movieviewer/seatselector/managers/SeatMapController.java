package com.praxis.movieviewer.seatselector.managers;

import com.praxis.movieviewer.seatselector.seatmap.models.SeatMapRowModel;

import java.util.List;

public interface SeatMapController {

  List<SeatMapRowModel> getSeatMapData();

  void initialize();

}
