package com.nanocorp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nanocorp.bean.dto.CampaignDto;
import com.nanocorp.service.CampaignService;

/**
 * Campaign controller.
 */
@Controller
@RequestMapping("/campaign")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@GetMapping("")
	@ResponseBody
	public List<CampaignDto> getCampaigns(HttpServletRequest request) {
		return campaignService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public CampaignDto getCampaign(@PathVariable long id, HttpServletRequest request) {
		return campaignService.findById(id);
	}
}
