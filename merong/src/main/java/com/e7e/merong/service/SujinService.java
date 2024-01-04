package com.e7e.merong.service;

import java.util.List;

import com.e7e.merong.vo.SujinVO;

//@Service , 절대 interface에 붙이면 안됨, 에러가 이상함!!!
//서비스는 왜 Mapper(DAO)랑 똑같을까?
public interface SujinService {
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
