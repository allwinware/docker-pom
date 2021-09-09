package com.allwin.docker;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.allwin.docker.infra.config.comm.consts.CommConsts;
import com.allwin.docker.infra.config.interceptor.RestTemplateLoggingRequestInterceptor;

/**
 * Web Configurer
 * com.allwin.docker WebConfig.java
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
@Configuration
@EnableWebMvc
@EnableAsync
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/static/webjars/", "classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/static/", "classpath:/META-INF/resources/");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
			// 로깅 인터셉터에서 Stream을 소비하므로 BufferingClientHttpRequestFactory 을 꼭 써야한다.
			.requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
			// 타임아웃 설정 (ms 단위)
//			.setConnectTimeout(CommConsts.CONNECT_TIMEOUT)
//			.setReadTimeout(CommConsts.READ_TIMEOUT)
			.setConnectTimeout(Duration.ofSeconds(CommConsts.CONNECT_TIMEOUT))
			.setReadTimeout(Duration.ofSeconds(CommConsts.READ_TIMEOUT))
			// UTF-8 인코딩으로 메시지 컨버터 추가
			.additionalMessageConverters(new StringHttpMessageConverter(CommConsts.CHARSET))
			// 로깅 인터셉터 설정
			.additionalInterceptors(new RestTemplateLoggingRequestInterceptor()).build();
	}

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false)
				.favorParameter(true)
				.parameterName("mediaType")
				.ignoreAcceptHeader(true)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml"	,MediaType.APPLICATION_XML)
				.mediaType("json"	,MediaType.APPLICATION_JSON);
	}

	/**
	 * Thread Pool
	 * @param
	 * @return	TaskExecutor
	 * @exception
	 */
	@Bean(name="threadPoolTaskExecutor")
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setQueueCapacity(100);
		taskExecutor.setMaxPoolSize(40);
//		taskExecutor.setCorePoolSize(100);
//		taskExecutor.setQueueCapacity(600);
//		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setThreadNamePrefix("GM-Executor-");
		taskExecutor.initialize();
		return taskExecutor;
	}

	/**
	 * Async Thread Pool
	 * @param
	 * @return	TaskExecutor
	 * @exception
	 */
	@Bean(name="asyncTaskExecutor")
	public TaskExecutor taskAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(100);
		taskExecutor.setQueueCapacity(600);
		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setThreadNamePrefix("async-task-executor-");
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(30 * 60 * 1000);	// 30 분
		configurer.registerCallableInterceptors(timeoutInterceptor());
	}

	@Bean
	public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
		return new TimeoutCallableProcessingInterceptor();
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginCheckInterceptor())
//								.excludePathPatterns("/common/check/**")	// System Check
//								.excludePathPatterns("/common/log**")		// Login, Logout
//								.excludePathPatterns("/error/**")
//								.excludePathPatterns("/js/**")
//								.excludePathPatterns("/css/**")
//								.excludePathPatterns("/test/**")
//								.excludePathPatterns("/images/**")
//								.excludePathPatterns("/test/**")
//								;
//	}
//
//	@Bean
//	public HandlerInterceptor loginCheckInterceptor() {
//		return new LoginCheckInterceptor();
//	}
}















