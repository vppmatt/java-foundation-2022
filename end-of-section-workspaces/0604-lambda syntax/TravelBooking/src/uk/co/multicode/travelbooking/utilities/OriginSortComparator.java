package uk.co.multicode.travelbooking.utilities;

import uk.co.multicode.travelbooking.domain.TravelTicket;

import java.util.Comparator;

public class OriginSortComparator implements Comparator<TravelTicket> {
    @Override
    public int compare(TravelTicket o1, TravelTicket o2) {
        return o1.getOrigin().compareTo(o2.getOrigin());
    }
}
