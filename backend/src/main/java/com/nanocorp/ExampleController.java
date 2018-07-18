package com.nanocorp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nanocorp.bean.db.Campaign;
import com.nanocorp.service.CampaignService;

/**
 * Example controller.
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

	@Autowired
	private CampaignService campaignService;

	@GetMapping("/{id}")
	@ResponseBody
	public Campaign sayHello(@PathVariable long id, HttpServletRequest request) {
		return campaignService.findById(id);
	}
}
