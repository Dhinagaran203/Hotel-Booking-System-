package com.project.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hotelbookingapp.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
