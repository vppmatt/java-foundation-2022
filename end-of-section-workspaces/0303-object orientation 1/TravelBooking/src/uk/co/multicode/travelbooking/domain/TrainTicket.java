package uk.co.multicode.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TrainTicket extends TravelTicket {

    private Integer travelClass;
    private Integer carriageNumber;
    private Integer seatNumber;

    public TrainTicket() {
        super();
    }

    public TrainTicket(Long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime, Integer travelClass, Integer carriageNumber, Integer seatNumber) {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.travelClass = travelClass;
        this.carriageNumber = carriageNumber;
        this.seatNumber = seatNumber;
    }

    public Integer getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(Integer travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(Integer carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void upgrade() {
        if(travelClass != 1) {
            travelClass = 1;
            System.out.println("You have been upgraded");
        }
        else {
            System.out.println("You are already in 1st class");
        }
    }
}
