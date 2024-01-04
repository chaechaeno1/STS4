package com.e7e.merong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.e7e.merong.vo.SujinVO;

@Mapper // 단순 표시 마크
public interface SujinMapper {
	
	// 당신이 똑똑하다면 기본적으로 5개를 먼저 만든다!
	// 리스트
	List<SujinVO> listSujin();

	// 조회
	SujinVO getSujin(SujinVO sujinVO);

	// 입력(등록)
	int insertSujin(SujinVO sujinVO);

	// 수정
	int updateSujin(SujinVO sujinVO);

	// 삭제
	int deleteSujin(SujinVO sujinVO);

}


