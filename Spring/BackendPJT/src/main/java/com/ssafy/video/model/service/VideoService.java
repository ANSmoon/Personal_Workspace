package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Video;

public interface VideoService {
	// 전체 영상 가져오기
	public abstract List<Video> getList();

	// 영상 하나 가져오기
	public abstract Video getVideo(int id);

}
