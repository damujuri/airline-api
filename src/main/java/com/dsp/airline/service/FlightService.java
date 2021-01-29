package com.dsp.airline.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsp.airline.entity.Flight;
import com.dsp.airline.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> getFlights() {
		return flightRepository.findAll();
	}

	public List<Flight> findFlights(String from, String to, Optional<Date> dateOfDeparture) {
		return flightRepository.findFlights(from, to, dateOfDeparture);
	}

	public void addFlight(Flight flight) {
		flightRepository.save(flight);

	}

	public Flight getFlightById(Long flightId) {
		return flightRepository.findById(flightId).get();
	}

}
