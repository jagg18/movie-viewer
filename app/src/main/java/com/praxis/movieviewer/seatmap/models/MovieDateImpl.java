package com.praxis.movieviewer.seatmap.models;

import com.google.gson.annotations.SerializedName;

public class MovieDateImpl extends BaseMovieDateImpl {

  @SerializedName("id")
  private String id;

  @SerializedName("label")
  private String label;

  @SerializedName("date")
  private String date;

  public MovieDateImpl() {

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
