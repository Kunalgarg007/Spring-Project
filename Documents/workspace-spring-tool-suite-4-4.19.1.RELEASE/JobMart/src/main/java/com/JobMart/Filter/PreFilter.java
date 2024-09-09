//package com.JobMart.Filter;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Enumeration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import com.JobMart.config.FilterConfiguration;
//import com.JobMart.entity.RequestWrapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class PreFilter extends OncePerRequestFilter {
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		RequestWrapper requestWrapper = new RequestWrapper(request);
//		ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(requestWrapper);
//		Enumeration<String> headerNames = wrappedRequest.getHeaderNames();
//		while (headerNames.hasMoreElements()) {
//			String headerName = headerNames.nextElement();
//			String headerValue = wrappedRequest.getHeader(headerName);
//
//			// Do something with the headerName and headerValue, for example, print them
//			System.out.println(headerName + ": " + headerValue);
//		}
//
////		if (headerNames != null) {
////		    while (headerNames.hasMoreElements()) {
////		        String name = headerNames.nextElement();
////		        System.out.println("Header: " + name + " value:" + wrappedRequest.getHeader(name));
////		    }
////		}
//		if (request.getMethod().equalsIgnoreCase("POST")) {
//			// Accessing request body
//			byte[] requestBodyBytes = wrappedRequest.getContentAsByteArray();
//			String requestBody = new String(requestBodyBytes, wrappedRequest.getCharacterEncoding());
//			System.out.println("Request Body: " + requestBody);
//			System.out.println("-111111111-" + getRequestBody(wrappedRequest));
//			// Continue the filter chain with the wrapped request
//			filterChain.doFilter(requestWrapper, response);
//		}
//	}
//
//	private String getRequestBody(ContentCachingRequestWrapper wrappedRequest) {
//
//		StringBuilder stringBuilder = new StringBuilder();
//		BufferedReader bufferedReader = null;
//		InputStream inputStream;
//		try {
//			inputStream = (wrappedRequest).getInputStream();
//
//			if (inputStream != null) {
//				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//				char[] charBuffer = new char[128];
//				int bytesRead = -1;
//				while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
//					stringBuilder.append(charBuffer, 0, bytesRead);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return stringBuilder.toString();
//	}
//
//	public void init(FilterConfiguration filterConfig) throws ServletException {
//		// Initialization code, if needed }
//	}
//
//	@Override
//	public void destroy() {
//		// Cleanup code, if needed
//	}
//}