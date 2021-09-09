package com.allwin.docker.infra.config.domain.rlt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * 
 * com.allwin.docker.infra.config.domain.rlt RltVo.java
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
public class RltVo {

	private	String	rltCd;
	private	String	rltMsg;
	private	Object	rltObj;
}
