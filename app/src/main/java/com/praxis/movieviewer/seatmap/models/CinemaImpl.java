package com.praxis.movieviewer.seatmap.models;

import com.google.gson.annotations.SerializedName;

public class CinemaImpl implements Cinema {

  @SerializedName("id")
  private String id;

  @SerializedName("cinema_id")
  private String cinemaId;

  @SerializedName("label")
  private String label;

  public CinemaImpl() {

  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
