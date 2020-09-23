package com.baeldung.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baeldung.entity.Photo;
import com.baeldung.exception.ResourceNotFoundException;
import com.baeldung.repository.PhotoRepository;

@Service
public class PhotoService {

	
	@Autowired
	private PhotoRepository photoRepository;
	
	public String savePhoto(String title, MultipartFile image) throws IOException {
		Photo photo = new Photo();
		photo.setTitle(title);
		photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		photo = photoRepository.save(photo);
		return photo.getId();
	}
	
	public Photo getById(String id) {
		return photoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
	}
}
