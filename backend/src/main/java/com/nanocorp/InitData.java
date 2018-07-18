package com.nanocorp;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanocorp.bean.Campaign;

@Component
public class InitData {

	@EventListener(ApplicationReadyEvent.class)
	private void startScheduledTasks() {
		ObjectMapper mapper = new ObjectMapper();
		String obj;
		try {
			File file = new File(getClass().getClassLoader().getResource("data/data.json").getFile());
			Campaign[] campaign = mapper.readValue(file, Campaign[].class);
			System.out.println(campaign);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
