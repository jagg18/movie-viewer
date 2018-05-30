package com.praxis.movieviewer.seatselector.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CinemaGroup {

  @SerializedName("parent")
  private String parent;

  @SerializedName("cinemas")
  private List<CinemaImpl> mCinemas;

  public CinemaGroup() {

  }

  public String getParent() {
    return parent;
  }

  public List<Cinema> getCinemas() {
    List<Cinema> cinemas = new ArrayList<>();
    for(Cinema cinema : mCinemas
            ) {
      cinemas.add(cinema);
    }
    return cinemas;
  }
}
