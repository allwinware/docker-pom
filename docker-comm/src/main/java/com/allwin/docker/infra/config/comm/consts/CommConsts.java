package com.allwin.docker.infra.config.comm.consts;

import java.nio.charset.Charset;

import org.apache.http.HttpHeaders;

/**
 * Common Constants
 * com.golfzon.newgm2.infra.config.common.consts CommConsts.java
 * @author	sjisbmoc
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 5.	sjisbmoc	최초생성
 * 
 * </pre>
 */
public class CommConsts {

	/*
	 * HTTP Header 상수
	 * */
	public static final String HTTP_HEADER_CONTENT_TYPE			= HttpHeaders.CONTENT_TYPE;
	public static final String HTTP_HEADER_CONTENT_LENGTH		= HttpHeaders.CONTENT_LENGTH;
	public static final String HTTP_HEADER_AUTHORIZATION		= HttpHeaders.AUTHORIZATION;
	public static final String HTTP_HEADER_SERVICE_IDKEY		= "ServiceIdKey";
	public static final String HTTP_HEADER_DEVICE_IDKEY			= "DeviceIdKey";
	public static final String HTTP_HEADER_API_VERSION			= "APIVersion";
	public static final String HTTP_HEADER_PROTOCOL				= "Protocol";
	public static final String FORMAT_HTTP_HEADER_AUTHORIZATION	= "Basic %s";
	public static final String FORMAT_AUTHORIZATION				= "%s:%s";

	// DateTime
	public static final String DATE_TIME_FORMAT					= "yyyy-MM-dd HH:mm:ss";
//	public static final String TIME_ZONE						= "UTC";
//	public static final String TIME_ZONE						= "Indian/Maldives";
	public static final String TIME_ZONE						= "Asia/Seoul";


	// RestTemplate 상수
	public static final	int		CONNECT_TIMEOUT					= 30 * 1000;		// 30초
	public static final	int		READ_TIMEOUT					= 60 * 1000 * 3;	// 3분
	public static final	Charset	CHARSET							= Charset.forName("UTF-8");

//	.setConnectTimeout(CommonConstants.CONNECT_TIMEOUT)
//	.setReadTimeout(CommonConstants.READ_TIMEOUT)
//	// UTF-8 인코딩으로 메시지 컨버터 추가
//	.additionalMessageConverters(new StringHttpMessageConverter(CommonConstants.CHARSET))

}
