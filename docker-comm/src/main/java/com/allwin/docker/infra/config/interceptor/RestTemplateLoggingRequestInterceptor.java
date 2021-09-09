package com.allwin.docker.infra.config.interceptor;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

/**
 * 
 * com.golfzon.newgm2.infra.config RestTemplateLoggingRequestInterceptor.java
 * @author	sjisbmoc
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 14.	sjisbmoc	최초생성
 * 
 * </pre>
 */
public class RestTemplateLoggingRequestInterceptor implements ClientHttpRequestInterceptor {

	private Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * <pre>
	 * RestTemplate 로깅 Interceptor
	 *
	 * <pre>
	 *
	 * @param request HttpRequest
	 * @param body Request Body
	 * @param execution ClientHttpRequestExecution
	 * @throws IOException
	 */
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		// request log
		URI uri		= request.getURI();
		traceRequest(request, body);

		// execute
		ClientHttpResponse response	= execution.execute(request, body);

		// response log
		traceResponse(response, uri);

		return response;
	}

	/**
	 * <pre>
	 * RestTemplate Request 로깅
	 *
	 * <pre>
	 * @param request HttpRequest
	 * @param body Request Body
	 */
	private void traceRequest(HttpRequest request, byte[] body) {

		StringBuilder reqLog	= new StringBuilder();
		reqLog.append("RestTemplateLoggingRequestInterceptor [REQUEST] ")
			.append("Uri : ").append(request.getURI())
			.append(", Method : ").append(request.getMethod())
			.append(", Request Body : ").append(new String(body, StandardCharsets.UTF_8));

		logger.info(reqLog.toString());
	}

	/**
	 * <pre>
	 * RestTemplate Response 로깅
	 *
	 * <pre>
	 * @param response ClientHttpResponse
	 * @throws IOException
	 */
	private void traceResponse(ClientHttpResponse response, URI uri) throws IOException {

		StringBuilder resLog	= new StringBuilder();
		resLog.append("RestTemplateLoggingRequestInterceptor [RESPONSE] ")
			.append("Uri : ").append(uri)
			.append(", Status code : ")
			.append(response.getStatusCode())
			.append(", Response Body : ")
			.append(StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));

		logger.info(resLog.toString());
	}
}

