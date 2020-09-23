package com.baeldung.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baeldung.service.PhotoService;

@RestController
@RequestMapping("/photos")
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@PostMapping
	public String savePhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException {
		return photoService.savePhoto(title, image);
	}
}
