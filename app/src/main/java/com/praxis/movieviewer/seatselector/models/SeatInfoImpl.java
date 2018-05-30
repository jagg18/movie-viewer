package com.praxis.movieviewer.seatselector.models;

public class SeatInfoImpl implements SeatInfo {

  private String seatName;
  private SeatStatus seatStatus;

  private double price;

  public SeatInfoImpl(String seatName, double price, SeatStatus seatStatus) {
    this.seatName = seatName;
    this.price = price;
    this.seatStatus = seatStatus;
  }

  @Override
  public String getName() {
    return seatName;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public SeatStatus getSeatStatus() {
    return seatStatus;
  }

  @Override
  public boolean equals(Object obj) {
//    return false;
    if(obj == this) {
      return true;
    }
    SeatInfo seatInfo = (SeatInfo) obj;
    return seatName.equals(seatInfo.getName());
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + seatName.hashCode();
    return result;
  }
}
