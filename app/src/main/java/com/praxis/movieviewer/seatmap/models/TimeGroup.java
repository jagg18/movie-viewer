package com.praxis.movieviewer.seatmap.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TimeGroup {

  @SerializedName("parent")
  private String parent;

  @SerializedName("times")
  private List<TimeImpl> mTimes;

  public TimeGroup() {

  }

  public String getParent() {
    return parent;
  }

  public List<Time> getTimes() {
    List<Time> times = new ArrayList<>();
    for(Time time : mTimes
            ) {
      times.add(time);
    }
    return times;
  }
}
