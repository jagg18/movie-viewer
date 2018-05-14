package com.praxis.movieviewer.seatmap.models;

public class SeatInfoImpl implements SeatInfo {

  private String seatName;

  private double price;

  public SeatInfoImpl(String seatName, double price) {
    this.seatName = seatName;
    this.price = price;
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
  public boolean equals(Object obj) {
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
