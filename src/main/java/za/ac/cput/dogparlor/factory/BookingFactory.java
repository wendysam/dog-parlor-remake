package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.*;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

public class BookingFactory {

    public static Booking createBooking(LocalDateTime bookingDate, Customer customer, List<Staff> staffList,
                                        List<GroomService> groomServices, List<ExtraService> extraServices, double total) {


        if (bookingDate == null || (Helper.isNullOrEmpty(bookingDate.getMonth().toString())))
            return null;

        if (groomServices.isEmpty())
            return null;

        if (total < 1)
            return null;

        String bookingID = Helper.generateID();

        return new Booking.Builder()
                .setBookingID(bookingID)
                .setBookingDate(bookingDate)
                .setCustomer(customer)
                .setStaffList(staffList)
                .setServices(groomServices)
                .setExtraServices(extraServices)
                .setTotal(total)
                .build();
    }

}
