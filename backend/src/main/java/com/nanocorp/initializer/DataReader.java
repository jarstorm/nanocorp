package com.nanocorp.initializer;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanocorp.bean.json.JsonCampaign;

/**
 * Read data from data.json. Every time the application wakes up readJsonValues is executed
 */
@Component
public class DataReader {

	private static Logger logger = LoggerFactory.getLogger(DataReader.class);

	@Autowired
	private DataCreator dataCreator;

	/**
	 * Read JSON values from data.json file. This method is called when the application startup process finished
	 */
	@EventListener(ApplicationReadyEvent.class)
	private void readJsonValues() {
		logger.info("Reading data from data.json file");
		ObjectMapper mapper = new ObjectMapper();
		try {
			File file = new File(DataReader.class.getClassLoader().getResource("./data/data.json").getFile());
			JsonCampaign[] campaigns = mapper.readValue(file, JsonCampaign[].class);
			dataCreator.createData(campaigns);
		} catch (IOException e) {
			logger.error("Could not initialize data from data.json file", e);
		}
	}

}
