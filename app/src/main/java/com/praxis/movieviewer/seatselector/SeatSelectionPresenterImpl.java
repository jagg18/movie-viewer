package com.praxis.movieviewer.seatselector;

import com.praxis.movieviewer.movieinfo.models.MovieSeatSelectionInfo;
import com.praxis.movieviewer.seatselector.data.GetScheduleInteractor;
import com.praxis.movieviewer.seatselector.data.GetScheduleInteractorLocalImpl;
import com.praxis.movieviewer.seatselector.data.GetSeatMapInteractor;
import com.praxis.movieviewer.seatselector.data.GetSeatMapInteractorLocalImpl;
import com.praxis.movieviewer.seatselector.managers.ScheduleController;
import com.praxis.movieviewer.seatselector.managers.ScheduleControllerImpl;
import com.praxis.movieviewer.seatselector.managers.SeatMapController;
import com.praxis.movieviewer.seatselector.managers.SeatMapControllerImpl;
import com.praxis.movieviewer.seatselector.managers.TicketController;
import com.praxis.movieviewer.seatselector.managers.TicketControllerImpl;
import com.praxis.movieviewer.seatselector.models.Cinema;
import com.praxis.movieviewer.seatselector.models.MovieDate;
import com.praxis.movieviewer.seatselector.models.Schedule;
import com.praxis.movieviewer.seatselector.models.SeatInfo;
import com.praxis.movieviewer.seatselector.models.SeatMap;
import com.praxis.movieviewer.seatselector.models.Time;

import java.text.DecimalFormat;
import java.util.List;

public class SeatSelectionPresenterImpl implements SeatSelectionPresenter, GetScheduleInteractor.OnFinishedListener, GetSeatMapInteractor.OnFinishedListener {

  private SeatSelectionView seatSelectionView;
  private MovieSeatSelectionInfo movieSeatSelectionInfo;

  // get movie schedule
  private GetScheduleInteractor getScheduleInteractor;
  // get movie seats
  private GetSeatMapInteractor getSeatMapInteractor;

  private ScheduleController scheduleController;
  private TicketController ticketController;
  private SeatMapController seatMapController;

  public SeatSelectionPresenterImpl(SeatSelectionView seatSelectionView, MovieSeatSelectionInfo movieSeatSelectionInfo) {
    this.seatSelectionView = seatSelectionView;

    // set data immediately
    seatSelectionView.setMovieSeatSelectionInfo(movieSeatSelectionInfo);

    // init interactor
    this.getScheduleInteractor = new GetScheduleInteractorLocalImpl(seatSelectionView.getContext());
    this.getSeatMapInteractor = new GetSeatMapInteractorLocalImpl(seatSelectionView.getContext());

    // init controllers
    ticketController = new TicketControllerImpl();
  }

  @Override
  public void onResume() {
    if(seatSelectionView != null) {
      seatSelectionView.showProgress();
    }

    getScheduleInteractor.getSchedule(this);
    getSeatMapInteractor.getSeatMap(this);
  }

  @Override
  public void onDestroy() {
    seatSelectionView = null;
  }

  private final String FORMAT_PRICE = "PhP #,##0.00";

  @Override
  public void onSeatsSelected(List<SeatInfo> selectedSeatsList) {
    double totalPrice = getTotalPrice(selectedSeatsList);
    // set total price in view
    seatSelectionView.setTotalPrice(getFormattedPrice(totalPrice));
  }

  public double getTotalPrice(List<SeatInfo> selectedSeatsList) {
    double price = 0;
    for(SeatInfo seatInfo : selectedSeatsList
            ) {
      price += seatInfo.getPrice();
    }
    return price;
  }

  private String getFormattedPrice(double price) {
//    NumberFormat format = NumberFormat.getCurrencyInstance();
//    return format.format(price);

    DecimalFormat format = new DecimalFormat(FORMAT_PRICE);
    return format.format(price);
  }

  @Override
  public void onSelectDate(MovieDate date) {
    // get cinemas for date
    List<Cinema> cinemas = scheduleController.getCinemasForDate(date);
    seatSelectionView.setCinemas(cinemas);
  }

  @Override
  public void onSelectCinema(Cinema cinema) {
    // get time slots for cinema
    List<Time> times = scheduleController.getTimesForCinema(cinema);
    seatSelectionView.setTimes(times);
  }

  @Override
  public void onSelectTime(Time time) {
    ticketController.setTime(time);

    seatMapController.initialize();
    displaySeats();
  }

  @Override
  public void onFinished(Schedule schedule) {
    // record schedule
    scheduleController = new ScheduleControllerImpl(schedule);

    seatSelectionView.setDates(scheduleController.getDates());
  }

  @Override
  public void onFinished(SeatMap seatMap) {
    seatMapController = new SeatMapControllerImpl(seatMap, ticketController);

    displaySeats();
  }

  @Override
  public void displaySeats() {
    seatSelectionView.displaySeats(seatMapController.getSeatMapData());
  }
}
