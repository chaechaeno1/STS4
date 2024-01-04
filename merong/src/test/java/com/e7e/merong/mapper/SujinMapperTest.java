package com.e7e.merong.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.e7e.merong.vo.SujinVO;

// 스프링에서는 설정 파일을 따로 작성해야 하는데 boot 에서는 어노테이션 하나만 작성하면 됨!
// 맵퍼 동작은 서비스/컨트롤러 만들기 전에 트스트로 검증하는 것이 유리!
@SpringBootTest
public class SujinMapperTest {

	@Autowired
	private SujinMapper sujinMapper;

	@Test
	@DisplayName("민채테스트")
	@Disabled // 이젠 테스트 안할거임
	public void insertTest() {

		SujinVO sujinVO;
		int effectedLine = 0;
		for (int i = 1; i <= 10; i++) {
			sujinVO = new SujinVO();
			sujinVO.setSujinName("민채" + i);
			sujinVO.setSujinContent("내용" + i);
			sujinVO.setSujinFile("파일" + i);

			effectedLine += sujinMapper.insertSujin(sujinVO);
		}

		// 테스트 결과는 effectedLine이 10이어야 한다. 아니면 실패!
		// assert -> 단정하다는 뜻..
		// assertEquals(내가 원하는 값, 변수);
		assertEquals(10, effectedLine);

	}

	@Test
	@DisplayName("민채테스트")
	public void deleteTest() {

		SujinVO sujinVO;
		int effectedLine = 0;
		for (int i = 1; i <= 41; i++) {
			sujinVO = new SujinVO();
			sujinVO.setSujinNum(i);
			effectedLine += sujinMapper.deleteSujin(sujinVO);
		}

		// 테스트 결과는 effectedLine이 10이어야 한다. 아니면 실패!
		// assert -> 단정하다는 뜻..
		// assertEquals(내가 원하는 값, 변수);
		assertEquals(40, effectedLine);

	}

}
