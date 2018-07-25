package com.nanocorp.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.nanocorp.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public byte[] getImage(String imageName) throws IOException {
		InputStream stream = resourceLoader.getResource("classpath:images/" + imageName).getInputStream();
		return IOUtils.toByteArray(stream);
	}

}
