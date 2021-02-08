package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTicketLuckyController {

		@PostMapping("/isMyTicketLucky")
		public boolean isMyTicketLucky(@RequestBody String tiketNumber) {
			return tiketNumber.chars().limit(3).sum() == tiketNumber.chars().skip(3).sum();
		}
}
