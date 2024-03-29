package com.ssafy.video.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.video.model.dto.Video;

public class VideoRepositoryImpl implements VideoRepository {
	
	private static VideoRepository repository = new VideoRepositoryImpl();
	
	private Map<Integer, Video> videos = new HashMap<>();
	
	private VideoRepositoryImpl() {
		videos.put(1, new Video("오랜만에 맛보는 프로의 어깨 운동 / 측면 어깨 부수기","아모띠", "상체", "https://www.youtube.com/embed/z4hSMVqWdqU?si=r73coAOp_HzuYZ7k" ));
		videos.put(2, new Video("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]","ThankyouBUBU", "전신", "https://www.youtube.com/embed/gMaB-fG4u4g" ));
		videos.put(3, new Video("하루 15분! 전신 칼로리 불태우는 다이어트 운동","ThankyouBUBU", "전신", "https://www.youtube.com/embed/swRNeYw1JkY" ));
		videos.put(4, new Video("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]","ThankyouBUBU", "상체", "https://www.youtube.com/embed/54tTYO-vU2E" ));
		videos.put(5, new Video("저는 하체 식주의자 입니다","김종국 GYM JONG KOOK", "하체", "https://www.youtube.com/embed/u5OgcZdNbMo" ));
		videos.put(6, new Video("11자복근 복부 최고의 운동 [복근 핵매운맛]","ThankyouBUBU", "복부", "https://www.youtube.com/embed/PjGcOP-TQPE" ));
	}

	
	public static VideoRepository getInstance() {
		return repository;
	}
	

	@Override
	public List<Video> selectAll() {
		List<Video> tmp = new ArrayList<>();
		for(int i : videos.keySet()) {
			tmp.add(videos.get(i));
		}
		
		return tmp;
	}

	@Override
	public Video selectOne(int id) {
		return videos.get(id);
	}

	@Override
	public void updateViewCnt(int id) {
		Video v = videos.get(id);
		v.setViewCnt(v.getViewCnt()+1);
		
	}

}
