package com.coco.project.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	MainMapper mainMapper;
	
	@Override
	public Map<String, Object> boardList(){
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("latestBoardList", mainMapper.latestBoardList());
		resultMap.put("popBoardList", mainMapper.popBoardList());
		
		return resultMap;
	}
}
