package com.store.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.store.dto.EventDTO;

@Mapper
public interface EventMapper {
	public List<EventDTO> findAllEvent();
}
