package com.nanocorp.initializer;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
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

	@Autowired
    private ResourceLoader resourceLoader;

	/**
	 * Read JSON values from data.json file. This method is called when the application startup process finished
	 */
	@EventListener(ApplicationReadyEvent.class)
	private void readJsonValues() {
		logger.info("Reading data from data.json file");
		ObjectMapper mapper = new ObjectMapper();
		try {
			InputStream stream = resourceLoader.getResource("classpath:data/data.json").getInputStream();
			JsonCampaign[] campaigns = mapper.readValue(stream, JsonCampaign[].class);
			dataCreator.createData(campaigns);
		} catch (IOException e) {
			logger.error("Could not initialize data from data.json file", e);
		}
	}

}
