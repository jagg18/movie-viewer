package com.praxis.movieviewer.seatmap;

import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.seatmap.models.Cinema;
import com.praxis.movieviewer.seatmap.models.MovieDate;
import com.praxis.movieviewer.seatmap.models.Schedule;
import com.praxis.movieviewer.seatmap.models.SeatInfo;
import com.praxis.movieviewer.seatmap.models.Time;

import java.text.DecimalFormat;
import java.util.List;

public class SeatSelectionPresenterImpl implements SeatSelectionPresenter, GetScheduleInteractor.OnFinishedListener {

  private final String FORMAT_PRICE = "PhP #,##0.00";

  private SeatSelectionView seatSelectionView;
  private MovieSeatSelectionInfo movieSeatSelectionInfo;

  private SelectedSeatsPresenter selectedSeatsPresenter;

  private GetScheduleInteractor getScheduleInteractor;

  private ScheduleController scheduleController;

  public SeatSelectionPresenterImpl(SeatSelectionView seatSelectionView, MovieSeatSelectionInfo movieSeatSelectionInfo) {
    this.seatSelectionView = seatSelectionView;

    // set data immediately
    seatSelectionView.setMovieSeatSelectionInfo(movieSeatSelectionInfo);

    selectedSeatsPresenter = new SelectedSeatsPresenterImpl(seatSelectionView.getSelectedSeatsView());

    // init interactor
    this.getScheduleInteractor = new GetScheduleInteractorLocalImpl(seatSelectionView.getContext());
  }

  @Override
  public void onResume() {
    if(seatSelectionView != null) {
      seatSelectionView.showProgress();
    }

    getScheduleInteractor.getSchedule(this);
  }

  @Override
  public void onDestroy() {
    seatSelectionView = null;
  }

  @Override
  public void getSeatMap() {
//    seatSelectionView.setMovieSeatSelectionInfo(movieSeatSelectionInfo);
  }

  @Override
  public void selectSeat(SeatInfo seatInfo) {
    selectedSeatsPresenter.selectSeat(seatInfo);

    double totalPrice = selectedSeatsPresenter.getTotalPrice();
    // set total price in view
    seatSelectionView.setTotalPrice(getFormattedPrice(totalPrice));
  }

  private String getFormattedPrice(double price) {
//    NumberFormat format = NumberFormat.getCurrencyInstance();
//    return format.format(price);

    DecimalFormat format = new DecimalFormat(FORMAT_PRICE);
    return format.format(price);
  }

  @Override
  public void onFinished(Schedule schedule) {
    // record schedule
    scheduleController = new ScheduleControllerImpl(schedule);

//    List<String> dates = new ArrayList<>();
//    for(MovieDate movieDate : schedule.getDates()
//            ) {
//      dates.add(movieDate.getLabel());
//    }

    seatSelectionView.setDates(scheduleController.getDates());
  }

  @Override
  public void onSelectDate(MovieDate date) {
    // get cinemas
    List<Cinema> cinemas = scheduleController.getCinemasForDate(date);
    seatSelectionView.setCinemas(cinemas);
  }

  @Override
  public void onSelectCinema(Cinema cinema) {
    // get times
    List<Time> times = scheduleController.getTimesForCinema(cinema);
    seatSelectionView.setTimes(times);
  }

  @Override
  public void onSelectTime(Time time) {

  }
}
