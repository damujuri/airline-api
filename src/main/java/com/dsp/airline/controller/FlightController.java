package com.dsp.airline.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsp.airline.entity.Flight;
import com.dsp.airline.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

	@Autowired
	FlightService flightService;

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {

		return flightService.getFlights();

	}

	@GetMapping(path = { "/flights/from/{from}/to/{to}/dateOfDeparture/{dateOfDeparture}",
			"/flights/from/{from}/to/{to}" })
	public List<Flight> findFlights(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("dateOfDeparture") @DateTimeFormat(pattern = "MM-dd-yyyy") Optional<Date> dateOfDeparture) {

		return flightService.findFlights(from, to, dateOfDeparture);

	}

	@GetMapping("/getFlightById/{flightId}")
	public Flight getFlightById(@PathVariable("flightId") Long flightId) {
		return flightService.getFlightById(flightId);
	}

	@PostMapping("/addFlight")
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
	}

}
