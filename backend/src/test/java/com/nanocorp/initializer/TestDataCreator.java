package com.nanocorp.initializer;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanocorp.bean.db.Campaign;
import com.nanocorp.bean.db.CustomUser;
import com.nanocorp.bean.json.JsonCampaign;
import com.nanocorp.dao.CampaignRepository;
import com.nanocorp.dao.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataCreator {

	@Autowired
	private DataCreator dataCreator;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CampaignRepository campaignRepository;

	@Test
	public void testEraseDatabaseCampaigns() throws JsonParseException, JsonMappingException, IOException {

		// Remove previous data
		campaignRepository.deleteAll();

		// Create a new user
		Campaign campaign = new Campaign();
		campaign.setName("New campaign");
		campaignRepository.save(campaign);

		// Check that there is only this user
		Assert.assertEquals(1, campaignRepository.findAll().size());

		ObjectMapper mapper = new ObjectMapper();
		File file = new File(getClass().getClassLoader().getResource("data/data-test.json").getFile());
		JsonCampaign[] campaigns = mapper.readValue(file, JsonCampaign[].class);
		dataCreator.createData(campaigns);

		// Only the campaigns created inside createData method should be in DB
		Assert.assertEquals(3, campaignRepository.findAll().size());
	}

	@Test
	public void testEraseDatabaseUsers() throws JsonParseException, JsonMappingException, IOException {

		// Remove previous data
		userRepository.deleteAll();

		// Create a new user
		CustomUser user = new CustomUser();
		user.setUsername("user");
		user.setPassword("password");
		userRepository.save(user);

		// Check that there is only this user
		Assert.assertEquals(1, userRepository.findAll().size());

		ObjectMapper mapper = new ObjectMapper();
		File file = new File(getClass().getClassLoader().getResource("data/data-test.json").getFile());
		JsonCampaign[] campaigns = mapper.readValue(file, JsonCampaign[].class);
		dataCreator.createData(campaigns);

		// Only the user created inside createData method should be in DB
		Assert.assertEquals(1, userRepository.findAll().size());
	}
}
