package com.nanocorp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nanocorp.service.ImageService;

/**
 * Image controller.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@GetMapping("/{imageName}")
	@ResponseBody
	public byte[] getImage(@PathVariable String imageName) throws IOException {
	   return imageService.getImage(imageName);
	}
}
