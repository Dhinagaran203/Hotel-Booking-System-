package com.project.hotelbookingapp.service;

import java.util.List;

import com.project.hotelbookingapp.model.Booking;
import com.project.hotelbookingapp.model.dto.BookingDTO;
import com.project.hotelbookingapp.model.dto.BookingInitiationDTO;

public interface BookingService {

    Booking saveBooking(BookingInitiationDTO bookingInitiationDTO, Long customerId);

    BookingDTO confirmBooking(BookingInitiationDTO bookingInitiationDTO, Long customerId);

    List<BookingDTO> findAllBookings();

    BookingDTO findBookingById(Long bookingId);

    List<BookingDTO> findBookingsByCustomerId(Long customerId);

    BookingDTO findBookingByIdAndCustomerId(Long bookingId, Long customerId);

    List<BookingDTO> findBookingsByManagerId(Long managerId);

    BookingDTO findBookingByIdAndManagerId(Long bookingId, Long managerId);

    BookingDTO mapBookingModelToBookingDto(Booking booking);

}
