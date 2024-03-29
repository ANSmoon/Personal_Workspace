package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Video;
import com.ssafy.video.model.repository.VideoRepository;
import com.ssafy.video.model.repository.VideoRepositoryImpl;

public class VideoServiceImpl implements VideoService {
	
	private static VideoService service = new VideoServiceImpl();
	private static VideoRepository repository = VideoRepositoryImpl.getInstance();
	
	private VideoServiceImpl() {
		
	}
	
	public static VideoService getInstance() {
		return service;
	}
	
	@Override
	public List<Video> getList() {
		return repository.selectAll();
	}

	@Override
	public Video getVideo(int id) {
		repository.updateViewCnt(id);
		return repository.selectOne(id);
	}

}
