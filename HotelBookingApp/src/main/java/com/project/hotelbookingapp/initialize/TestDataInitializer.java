package com.project.hotelbookingapp.initialize;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.hotelbookingapp.model.*;
import com.project.hotelbookingapp.model.enums.RoleType;
import com.project.hotelbookingapp.model.enums.RoomType;
import com.project.hotelbookingapp.repository.*;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final HotelManagerRepository hotelManagerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;
    private final HotelRepository hotelRepository;
    private final AvailabilityRepository availabilityRepository;

    @Override
    @Transactional
    public void run(String... args) {

        try {
            log.warn("Checking if test data persistence is required...");

            if (roleRepository.count() == 0 && userRepository.count() == 0) {
                log.info("Initiating test data persistence");

                Role adminRole = new Role(RoleType.ADMIN);
                Role customerRole = new Role(RoleType.CUSTOMER);
                Role hotelManagerRole = new Role(RoleType.HOTEL_MANAGER);

                roleRepository.save(adminRole);
                roleRepository.save(customerRole);
                roleRepository.save(hotelManagerRole);
                log.info("Role data persisted");

                User user1 = User.builder().username("admin@hotel.com").password(passwordEncoder.encode("password")).name("Dhinagaran").lastName("R").role(adminRole).build();
                User user2 = User.builder().username("customer1@hotel.com").password(passwordEncoder.encode("password")).name("Brock").lastName("Leasnar").role(customerRole).build();
                User user3 = User.builder().username("manager1@hotel.com").password(passwordEncoder.encode("password")).name("Dhinesh").lastName("Kumar").role(hotelManagerRole).build();
                User user4 = User.builder().username("manager2@hotel.com").password(passwordEncoder.encode("password")).name("Will").lastName("Smith").role(hotelManagerRole).build();

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);

                Admin admin1 = Admin.builder().user(user1).build();
                Customer c1 = Customer.builder().user(user2).build();
                HotelManager hm1 = HotelManager.builder().user(user3).build();
                HotelManager hm2 = HotelManager.builder().user(user4).build();

                adminRepository.save(admin1);
                customerRepository.save(c1);
                hotelManagerRepository.save(hm1);
                hotelManagerRepository.save(hm2);
                log.info("User data persisted");

                Address addressIst1 = Address.builder().addressLine("Villupuram New Bus Stand Road").city("Villupuram")
                        .country("India").build();
                Address addressIst2 = Address.builder().addressLine("716 Nehruji Road, Mahalakshmi Plaza").city("Villupuram")
                        .country("India").build();
                Address addressIst3 = Address.builder().addressLine("1193 Trichy Main Road, Villupuram-605602").city("Villupuram")
                        .country("India").build();

                Address addressBerlin1 = Address.builder().addressLine("1, Mansingh Road, South Block, Man Singh Road Area").city("New Delhi")
                        .country("India").build();
                Address addressBerlin2 = Address.builder().addressLine("150 Piccadilly, St. James, London W1J 9BR").city("London")
                        .country("United Kingdom").build();
                Address addressBerlin3 = Address.builder().addressLine("10 Bayfront Avenue, Singapore 018956").city("Marina Bay")
                        .country("Singapore").build();

                addressRepository.save(addressIst1);
                addressRepository.save(addressIst2);
                addressRepository.save(addressIst3);
                addressRepository.save(addressBerlin1);
                addressRepository.save(addressBerlin2);
                addressRepository.save(addressBerlin3);

                Hotel hotelIst1 = Hotel.builder().name("KVR Guest House Boarding")
                        .address(addressIst1).hotelManager(hm1).build();
                Hotel hotelIst2 = Hotel.builder().name("Hotel Grand Kubera Hotel")
                        .address(addressIst2).hotelManager(hm1).build();
                Hotel hotelIst3 = Hotel.builder().name("Krish Residency Hotel")
                        .address(addressIst3).hotelManager(hm1).build();

                Hotel hotelBerlin1 = Hotel.builder().name("The Taj Mahal Hotel")
                        .address(addressBerlin1).hotelManager(hm2).build();
                Hotel hotelBerlin2 = Hotel.builder().name("The Ritz London")
                        .address(addressBerlin2).hotelManager(hm2).build();
                Hotel hotelBerlin3 = Hotel.builder().name("Marina Bay Sands")
                        .address(addressBerlin3).hotelManager(hm2).build();

                Room singleRoomIst1 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(1200).roomCount(35).hotel(hotelIst1).build();
                Room doubleRoomIst1 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(1500).roomCount(45).hotel(hotelIst1).build();

                Room singleRoomIst2 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(1400).roomCount(25).hotel(hotelIst2).build();
                Room doubleRoomIst2 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(1000).roomCount(30).hotel(hotelIst2).build();

                Room singleRoomIst3 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(800).roomCount(30).hotel(hotelIst3).build();
                Room doubleRoomIst3 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(1200).roomCount(75).hotel(hotelIst3).build();

                Room singleRoomBerlin1 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(120).roomCount(25).hotel(hotelBerlin1).build();
                Room doubleRoomBerlin1 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(250).roomCount(15).hotel(hotelBerlin1).build();

                Room singleRoomBerlin2 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(300).roomCount(50).hotel(hotelBerlin2).build();
                Room doubleRoomBerlin2 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(400).roomCount(50).hotel(hotelBerlin2).build();

                Room singleRoomBerlin3 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(199).roomCount(45).hotel(hotelBerlin3).build();
                Room doubleRoomBerlin3 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(299).roomCount(25).hotel(hotelBerlin3).build();

                hotelIst1.getRooms().addAll(Arrays.asList(singleRoomIst1,doubleRoomIst1));
                hotelIst2.getRooms().addAll(Arrays.asList(singleRoomIst2,doubleRoomIst2));
                hotelIst3.getRooms().addAll(Arrays.asList(singleRoomIst3,doubleRoomIst3));
                hotelBerlin1.getRooms().addAll(Arrays.asList(singleRoomBerlin1,doubleRoomBerlin1));
                hotelBerlin2.getRooms().addAll(Arrays.asList(singleRoomBerlin2,doubleRoomBerlin2));
                hotelBerlin3.getRooms().addAll(Arrays.asList(singleRoomBerlin3,doubleRoomBerlin3));

                hotelRepository.save(hotelIst1);
                hotelRepository.save(hotelIst2);
                hotelRepository.save(hotelIst3);
                hotelRepository.save(hotelBerlin1);
                hotelRepository.save(hotelBerlin2);
                hotelRepository.save(hotelBerlin3);
                log.info("Hotel data persisted");

                Availability av1Berlin1 = Availability.builder().hotel(hotelBerlin1)
                        .date(LocalDate.of(2025,4,1)).room(singleRoomBerlin1).availableRooms(5).build();
                Availability av2Berlin1 = Availability.builder().hotel(hotelBerlin1)
                        .date(LocalDate.of(2023,4,2)).room(doubleRoomBerlin1).availableRooms(7).build();

                availabilityRepository.save(av1Berlin1);
                availabilityRepository.save(av2Berlin1);
                log.info("Availability data persisted");

            } else {
                log.info("Test data persistence is not required");
            }
            log.warn("App ready");
        } catch (DataAccessException e) {
            log.error("Exception occurred during data persistence: " + e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected exception occurred: " + e.getMessage());
        }
    }
}
