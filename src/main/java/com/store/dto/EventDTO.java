package com.store.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Alias("EventDTO")
public class EventDTO {
	int eventsIdx;
	String eventsName;
	String eventsInfo;
	LocalDate eventsStart;
	LocalDate eventsEnd;
	String eventsImg;
}
