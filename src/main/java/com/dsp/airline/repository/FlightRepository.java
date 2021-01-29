package com.dsp.airline.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsp.airline.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and "
    		+ "DATE(date_of_departure) = IFNULL(DATE(:dateOfDeparture), DATE(dateOfDeparture)) ")
    List<Flight> findFlights(@Param("departureCity")String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Optional<Date> dateOfDeparture);
}
