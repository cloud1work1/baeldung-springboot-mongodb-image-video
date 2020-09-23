package com.baeldung.service;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baeldung.entity.Video;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class VideoService {

	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Autowired
	private GridFsOperations gridFsOperations;
	
	public String saveVideo(String title, MultipartFile video) throws IOException {
		DBObject metadata = new BasicDBObject();
		metadata.put("type", "video");
		metadata.put("title", title);
		ObjectId id = gridFsTemplate.store(video.getInputStream(), video.getName(), video.getContentType(), metadata);
		return id.toString();
	}
	
	public Video findById(String id) throws IllegalStateException, IOException {
		GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		Video video = new Video();
		video.setTitle(file.getMetadata().get("title").toString());
		video.setInoutStream(gridFsOperations.getResource(file).getInputStream());
		return video;
	}
}
