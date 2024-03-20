package com.ssafy.video.model.repository;

import java.util.List;

import com.ssafy.video.model.dto.Video;

public interface VideoRepository {
	
	public abstract List<Video> selectAll();

	public abstract Video selectOne(int id);

	public abstract void updateViewCnt(int id);
}
