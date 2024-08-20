package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.dto.EventDTO;
import com.store.mapper.EventMapper;

@Service
public class EventServiceImpl implements EventService {

	EventMapper eventMapper;

	public EventServiceImpl(EventMapper eventMapper) {
		this.eventMapper = eventMapper;
	}

	@Override
	public List<EventDTO> findAllEvent() {
		return eventMapper.findAllEvent();
	}

}
