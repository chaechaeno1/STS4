package com.e7e.merong.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString //디버깅에 유리, 1개씩 안 찍고 전체 속성 찍어줌
public class SujinVO {
	private int sujinNum;
	private String sujinName;
	private String sujinContent;
	private String sujinFile;

}


