package com.praxis.movieviewer.seatselector.managers;

import com.praxis.movieviewer.seatselector.models.Cinema;
import com.praxis.movieviewer.seatselector.models.MovieDate;
import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.models.Time;

import java.util.List;

public interface TicketController {

  void setTime(Time time);

  // temp method to compute price per seat
  // open to possibility of different prices per seat
  double getTicketPriceForSeat(String seatName);

}
