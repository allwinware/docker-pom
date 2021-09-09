package com.allwin.docker;


import org.apache.http.HttpHeaders;

import com.allwin.docker.infra.config.comm.consts.CommConsts;

/**
 * Infra Constants
 * com.golfzon.newgm2.infra.config.common.consts InfraConsts.java
 * @author	sjisb
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 5.	sjisb		최초생성
 * 
 * </pre>
 */
public class InfraConsts {

	/*
	 * HTTP Header 상수
	 * */
	public static final String	HTTP_HEADER_ACCEPT_ENCODING				= HttpHeaders.ACCEPT_ENCODING;
	public static final String	HTTP_HEADER_CONTENT_TYPE				= HttpHeaders.CONTENT_TYPE;
	public static final String	HTTP_HEADER_CONTENT_LENGTH				= HttpHeaders.CONTENT_LENGTH;
	public static final String	HTTP_HEADER_AUTHORIZATION				= HttpHeaders.AUTHORIZATION;
	public static final String	HTTP_HEADER_SERVICE_IDKEY				= "ServiceIdKey";
	public static final String	HTTP_HEADER_DEVICE_IDKEY				= "DeviceIdKey";
	public static final String	HTTP_HEADER_API_VERSION					= "APIVersion";
	public static final String	HTTP_HEADER_PROTOCOL					= "Protocol";
	public static final String	FORMAT_HTTP_HEADER_AUTHORIZATION		= "Basic %s";
	public static final String	FORMAT_AUTHORIZATION					= "%s:%s";

	/*
	 * Redis 상수
	 * */
	// Redis DB Index
	public static final int		REDIS_INDEX_AUTHORIZATION				= 0;
	public static final int		REDIS_INDEX_POLICY						= 1;
	public static final int		REDIS_INDEX_TRANSACTION					= 2;

	// Redis DB Key 저장 패턴
	/*
		application:<licenseKey>
		service:<serviceId>:<serviceKey>
		device:<deviceOriginalId>:<deviceKey>
		gateway:<gatewayId>:<gatewayKey>
		biz-platform:<authKey>
	*/
	public static final String REDIS_KEY_AUTHORIZATION_PATTERN2			= "%s:%s";			// prefix:<id>
	public static final String REDIS_KEY_AUTHORIZATION_PATTERN3			= "%s:%s:%s";		// prefix:<id>:<key>
	public static final String REDIS_KEY_POLICY_PATTERN 				= "%s:%s:%s";		// prefix:<AmqpMessageType>:<AmqpDataType> or <ControlType>
	public static final String REDIS_KEY_TRANSACTION_PATTERN 			= "%s:%s:%s:%s";	// prefix:<protocol>:<deviceOriginalId>:<messageId>
	public static final String REDIS_KEY_DEVICE_CONTROL_INDEX			= "%s:%s";			// prefix:<deviceId>;
	public static final String REDIS_KEY_DEVICE_FAULT_PATTERN			= "%s:%s:%s:%s:%s";	// prefix:<deviceId>:<taretType>:<targetKey>:<targetId>

	// Redis DB Value 저장 패턴
	public static final String REDIS_VALUE_TRANSACTION_PATTERN			= "%s:%s:%s:%s";	// 	<controlType>:<deviceId>:<subdeviceOriginalId>:<controlId>

	// Infra DateTime Format
	public static final String	DATE_TIME_FORMAT						= CommConsts.DATE_TIME_FORMAT;
	public static final String	INFRA_TIME_ZONE							= CommConsts.TIME_ZONE;

	// Gateway URL Format
	public static final String	GATEWAY_URL_FORMAT						= "http://%s:%d";

	// Convert : DateTime
	public static final String	CONVERT_DATE_TIME_TARGET				= "DateTime";

	// Job 기동 방식
	public static final String BACH_JOB_RUN_TYPE_INTERVAL				= "INTERVAL";	// 주기적으로
	public static final String BACH_JOB_RUN_TYPE_CRON					= "CRON";		// Cron expression 에 따라
	public static final String BACH_JOB_RUN_TYPE_EXCUTE					= "EXCUTE";		// 한번만

	// 파라미터 기본 설정 값
	public static final String DEFAULT_VALUE_NONE						= "none";		// None
}
