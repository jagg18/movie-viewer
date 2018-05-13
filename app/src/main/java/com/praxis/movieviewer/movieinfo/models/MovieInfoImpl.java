package com.praxis.movieviewer.movieinfo.models;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MovieInfoImpl implements MovieInfo {

  @SerializedName("movie_id")
  private String movieId;

  @SerializedName("advisory_rating")
  private String advisoryRating;

  @SerializedName("canonical_title")
  private String canonicalTitle;

  @SerializedName("cast")
  private List<String> cast;

  @SerializedName("genre")
  private String genre;

  @SerializedName("has_schedules")
  private int hasSchedules;

  @SerializedName("is_inactive")
  private int isInactive;

  @SerializedName("is_showing")
  private int isShowing;

  @SerializedName("link_name")
  private String linkName;

  @SerializedName("poster")
  private String posterUrl;

  @SerializedName("poster_landscape")
  private String posterLandscapeUrl;

//  private Object ratings;

  @SerializedName("release_date")
  private String releaseDate;

  @SerializedName("runtime_mins")
  private double runtimeMins;

  @SerializedName("synopsis")
  private String synopsis;

  @SerializedName("trailer")
  private String trailer;

//private Object averageRating;
//private Object totalReviews;

  @SerializedName("variants")
  private List<String> variants;

  @SerializedName("theater")
  private String theater;

  @SerializedName("order")
  private int order;

  @SerializedName("is_featured")
  private int isFeatured;

  @SerializedName("watch_list")
  private boolean watchList;

  @SerializedName("your_rating")
  private int yourRating;

  public MovieInfoImpl() {

  }

  @Override
  public String getTitle() {
    return canonicalTitle;
  }

  @Override
  public String getGenre() {
    return genre;
  }

  @Override
  public String getAdvisoryRating() {
    return advisoryRating;
  }

  @Override
  public String getDuration() {
//    runtimeMins = 121;

    int hours = (int) (runtimeMins / 60);
    int mins = (int) (runtimeMins % 60);

    StringBuilder sb = new StringBuilder();

    if(hours == 1) {
      sb.append(String.format("%dhr", hours));
    } else if(hours > 1) {
      sb.append(String.format("%dhrs", hours));
    }

    if(mins == 1) {
      sb.append(String.format(" %dmin", mins));
    } else if(mins > 1) {
      sb.append(String.format(" %dmins", mins));
    }

    return sb.toString();
  }

  @Override
  public String getReleaseDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date dRelease = sdf.parse(releaseDate);
      sdf.applyPattern("MMMM dd, YYYY");
      return sdf.format(dRelease);
    } catch(ParseException e) {
      e.printStackTrace();
    }

    return releaseDate;
  }

  @Override
  public String getSynopsis() {
    return synopsis;
  }

  @Override
  public String getCast() {
    return TextUtils.join(", ", cast);
  }

  @Override
  public String getPosterLandscapeUrl() {
    return posterLandscapeUrl;
  }

  @Override
  public String getPosterUrl() {
    return posterUrl;
  }
}
