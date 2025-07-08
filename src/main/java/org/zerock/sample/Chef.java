package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 듸존성 처리해줘
@Data // import lombok.Data; dto처리용(게터/세터, toString, equals 등)

public class Chef {
	
	private String name;
	private int age;

}
