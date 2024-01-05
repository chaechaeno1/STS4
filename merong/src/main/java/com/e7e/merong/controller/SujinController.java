package com.e7e.merong.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.e7e.merong.service.SujinService;
import com.e7e.merong.vo.SujinVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//컨트롤러는 접수창고! 모든 고객요청은 접수창고를 거쳐야 한다.
//@Controller
@RequestMapping("/api")
@RestController // @ResponseBody + @Controller
public class SujinController {

	/*
	 * Restful api 서비스는 get 조회, post 생성, put 수정, delete 삭제 강제 아니고, 관례!
	 * 
	 */

	// 컨트롤러는 서비스를 부른다!
	@Autowired
	private SujinService sujinService;

	@GetMapping("/sujins")
	public List<SujinVO> listSujin() {
		return sujinService.listSujin();

	}

	@GetMapping("/sujins/{seqNum}")
	public SujinVO getSujin(@PathVariable int seqNum) {

		SujinVO sujinVO = new SujinVO();
		sujinVO.setSujinNum(seqNum);

		return sujinService.getSujin(sujinVO);

	}

	/*
	 * 파일이 포함 안되어 있을 때, @RequestBody 필요
	 * 
	 * // 메소드 요청에 의해서 구분되기 때문에.. url 똑같음
	 * 
	 * @PostMapping("/sujins") public int insertSujin(@RequestBody SujinVO sujinVO)
	 * { return sujinService.insertSujin(sujinVO); }
	 */

	
	
	
	// 파일이 포함 되어 있을 때, @RequestBody 불필요
	@PostMapping("/sujins")
	public int insertSujin(SujinVO sujinVO) throws Exception {
		log.debug("체크 sujinVO {}",sujinVO);
		
		MultipartFile recFile = sujinVO.getSujinFile2();
		String baseFolder = "c:/myUpload/";
		String fileName = recFile.getOriginalFilename();
		recFile.transferTo(new File(baseFolder + fileName));
		
		String webBase = "/mcimg/";
		sujinVO.setSujinFile(webBase + fileName);
		
		return sujinService.insertSujin(sujinVO);
	}


	
	
	@PutMapping("/sujins")
	public int updateSujin(@RequestBody SujinVO sujinVO) {
		return sujinService.updateSujin(sujinVO);
	}

	@DeleteMapping("/sujins/{seqNum}")
	public int deleteSujin(@PathVariable int seqNum) {

		SujinVO sujinVO = new SujinVO();
		sujinVO.setSujinNum(seqNum);

		return sujinService.deleteSujin(sujinVO);

	}

	// 파일처리
	@PostMapping("/sfile")
	public String postFile(MultipartFile mc) throws IllegalStateException, IOException {
		log.debug("파일이름 : {}", mc.getOriginalFilename());
		log.debug("파일사이즈 : {}", mc.getSize());

		// 저장
		mc.transferTo(new File("c:/myUpload/" + mc.getOriginalFilename()));

		// 파일에 대한 웹 접근 경로를 리턴
		return "/mcimg/" + mc.getOriginalFilename();
	}

}
