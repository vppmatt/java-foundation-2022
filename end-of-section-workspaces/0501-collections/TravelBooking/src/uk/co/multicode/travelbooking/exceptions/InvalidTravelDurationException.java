package cuk.co.multicode.travelbooking.exceptions;

public class InvalidTravelDurationException extends Exception{

    public InvalidTravelDurationException() {
        super();
    }

    public InvalidTravelDurationException(String message) {
        super(message);
    }
}
