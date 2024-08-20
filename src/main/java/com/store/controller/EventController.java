package com.store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.EventDTO;
import com.store.service.EventService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EventController {
	EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping("/")
	public List<EventDTO> findAllEvent() {
		List<EventDTO> eventDTO = eventService.findAllEvent();
		return eventDTO;
	}
}
