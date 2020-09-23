package com.baeldung.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baeldung.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@PostMapping
	public String saveVideo(@RequestParam("title") String title, @RequestParam("video") MultipartFile video) throws IOException {
		return videoService.saveVideo(title, video);
	}
}
