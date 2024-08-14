package com.store.service;

import java.util.List;
import com.store.dto.EventDTO;

public interface EventService {
	List<EventDTO> findAllEvent();
}
