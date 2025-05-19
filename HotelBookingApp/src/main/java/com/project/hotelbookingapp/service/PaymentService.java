package com.project.hotelbookingapp.service;

import com.project.hotelbookingapp.model.Booking;
import com.project.hotelbookingapp.model.Payment;
import com.project.hotelbookingapp.model.dto.BookingInitiationDTO;

public interface PaymentService {

    Payment savePayment(BookingInitiationDTO bookingInitiationDTO, Booking booking);
}
