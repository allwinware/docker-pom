package com.allwin.docker.infra.config.domain.rlt;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 
 * com.allwin.docker.infra.config.domain.rlt RltStat.java
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
@Data
@JsonSerialize
@JsonInclude(Include.NON_NULL)
public class RltStat {

	public RltStat(HttpStatus httpStatus) {
		setHttpStat(httpStatus);
	}

	public RltStat(String rltCd, String rltMsg, HttpStatus httpStatus) {
		setRltCd(rltCd);
		setRltMsg(rltMsg);
		setHttpStat(httpStatus);
	}

	private	String		rltCd;
	private	String		rltMsg;
	private	HttpStatus	httpStat;
}
