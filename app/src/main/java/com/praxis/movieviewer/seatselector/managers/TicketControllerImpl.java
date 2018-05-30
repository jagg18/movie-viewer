package com.praxis.movieviewer.seatselector.managers;

import com.praxis.movieviewer.seatselector.models.Time;

public class TicketControllerImpl implements TicketController {

  private Time time;

  public TicketControllerImpl() {
  }

  public void setTime(Time time) {
    this.time = time;
  }

  @Override
  public double getTicketPriceForSeat(String seatName) {
    if(time == null) {
      return 0;
    }
    // return regular price
    return time.getPrice();

    // check for special seat prices
  }
}
