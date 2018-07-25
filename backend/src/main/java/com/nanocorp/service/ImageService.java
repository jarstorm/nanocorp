package com.nanocorp.service;

import java.io.IOException;

/**
 * Image service
 */
public interface ImageService {

	/**
	 * Get image content
	 */
	byte[] getImage(String imageName) throws IOException;
}
