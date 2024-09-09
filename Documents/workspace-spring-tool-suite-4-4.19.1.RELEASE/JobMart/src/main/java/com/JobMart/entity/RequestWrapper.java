package com.JobMart.entity;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;


public class RequestWrapper extends HttpServletRequestWrapper {
    
 
   private final String xmlPayload;
    
   public RequestWrapper (HttpServletRequest request) {
        
       super(request);
        
       // read the original payload into the xmlPayload variable
       StringBuilder stringBuilder = new StringBuilder();
       BufferedReader bufferedReader = null;
       try {
           // read the payload into the StringBuilder
           InputStream inputStream = request.getInputStream();
           if (inputStream != null) {
               bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
               char[] charBuffer = new char[128];
               int bytesRead = -1;
               while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                   stringBuilder.append(charBuffer, 0, bytesRead);
               }
           } else {
               // make an empty string since there is no payload
               stringBuilder.append("");
           }
       } catch (Exception ex) {
       } finally {
           if (bufferedReader != null) {
               try {
                   bufferedReader.close();
               } catch (IOException iox) {
                   // ignore
               }
           }
       }
       xmlPayload = stringBuilder.toString();
   }
 
   /**
    * Override of the getInputStream() method which returns an InputStream that reads from the
    * stored XML payload string instead of from the request's actual InputStream.
    */
   @Override
   public ServletInputStream getInputStream()
       throws IOException {
        
       final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlPayload.getBytes());
       ServletInputStream inputStream = new ServletInputStream() {
           public int read () 
               throws IOException {
               return byteArrayInputStream.read();
           }

		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setReadListener(ReadListener readListener) {
			// TODO Auto-generated method stub
			
		}
       };
       return inputStream;
   }
    
}