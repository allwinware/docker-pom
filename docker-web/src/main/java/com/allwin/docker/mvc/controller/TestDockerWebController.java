package com.allwin.docker.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allwin.docker.infra.config.domain.rlt.RltStat;

import lombok.extern.slf4j.Slf4j;

/**
 * Test Docker WEB Controller
 * com.allwin.docker.mvc.controller TestDockerWebController.java
 * @author	john
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 9. 8.	john		최초생성
 * 
 * </pre>
 */
@Slf4j
@Controller
public class TestDockerWebController {

	@ResponseBody
	@RequestMapping(value="/test/msg"	,produces=MediaType.APPLICATION_JSON_VALUE	,method={RequestMethod.GET, RequestMethod.POST})
	public Object testLogYml(/*@RequestBody AgsPaySnInfo agsPaySnInfo, */HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("####################################################################################################");
		log.debug("Docker WEB Test");
		log.debug("####################################################################################################");

		return new RltStat("200","Test Docker WEB - ver 42",HttpStatus.ACCEPTED);
	}
}














