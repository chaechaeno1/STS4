package com.e7e.merong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e7e.merong.mapper.SujinMapper;
import com.e7e.merong.vo.SujinVO;

@Service
public class SujinServiceImpl implements SujinService {
	//★★★★★서비스는 맵퍼를 부른다!
	@Autowired
	private SujinMapper sujinMapper;

	@Override
	public List<SujinVO> listSujin() {

		return sujinMapper.listSujin();
	}

	@Override
	public SujinVO getSujin(SujinVO sujinVO) {

		return sujinMapper.getSujin(sujinVO);
	}

	@Override
	public int insertSujin(SujinVO sujinVO) {

		return sujinMapper.insertSujin(sujinVO);
	}

	@Override
	public int updateSujin(SujinVO sujinVO) {

		return sujinMapper.updateSujin(sujinVO);
	}

	@Override
	public int deleteSujin(SujinVO sujinVO) {

		return sujinMapper.deleteSujin(sujinVO);
	}

}
