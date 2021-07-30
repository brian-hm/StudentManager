package com.delta.studentManager.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
	void init();

	void save(MultipartFile file);
	
	Resource load(String filename);
}
