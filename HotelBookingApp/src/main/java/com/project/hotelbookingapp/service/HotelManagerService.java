package com.project.hotelbookingapp.service;

import com.project.hotelbookingapp.model.HotelManager;
import com.project.hotelbookingapp.model.User;

public interface HotelManagerService {

    HotelManager findByUser(User user);

}
