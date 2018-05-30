package com.praxis.movieviewer.seatselector.models;

import java.util.List;

public interface SeatMap {

  List<SeatMapRow> getSeatMap();

  List<String> getAvailableSeats();

}
