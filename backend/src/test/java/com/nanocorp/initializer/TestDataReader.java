package com.nanocorp.initializer;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanocorp.bean.json.JsonCampaign;

public class TestDataReader {

	@Test
	public void testReadCampaignsLength() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(getClass().getClassLoader().getResource("data/data-test.json").getFile());
		JsonCampaign[] campaigns = mapper.readValue(file, JsonCampaign[].class);
		Assert.assertEquals(3, campaigns.length);
	}

	@Test
	public void testReadCampaigns1Valid() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(getClass().getClassLoader().getResource("data/data-test.json").getFile());
		JsonCampaign[] campaigns = mapper.readValue(file, JsonCampaign[].class);
		JsonCampaign campaign = campaigns[0];
		Assert.assertEquals(100000001, campaign.getId());
		Assert.assertEquals("Test Ad 1", campaign.getName());
		Assert.assertEquals("Increase Reach", campaign.getGoal());
		Assert.assertEquals("Delivering", campaign.getStatus());
		// And so on with this test
	}
}
