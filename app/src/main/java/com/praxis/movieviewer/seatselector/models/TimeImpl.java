package com.praxis.movieviewer.seatselector.models;

import com.google.gson.annotations.SerializedName;

public class TimeImpl implements Time {

  @SerializedName("id")
  private String id;

  @SerializedName("label")
  private String label;

  @SerializedName("schedule_id")
  private String scheduleId;

  @SerializedName("popcorn_price")
  private double popcornPrice;

  @SerializedName("popcorn_label")
  private String popcornLabel;

  @SerializedName("seating_type")
  private String seatingType;

  @SerializedName("price")
  private double price;

//  private String variant;

  public TimeImpl() {

  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
