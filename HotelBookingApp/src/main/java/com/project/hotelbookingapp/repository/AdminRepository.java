package com.project.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hotelbookingapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
