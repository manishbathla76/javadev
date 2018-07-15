package com.moneymachine.commontools.extractorutil;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HTTPServerThread extends Thread{
	
	public void run(){
		try{
		HttpServer server = HttpServer.create(new InetSocketAddress(Constants.ACCESS_PORT), 0);
        server.createContext("/getAllFileNames", new AllFileNames());
        server.setExecutor(null); // creates a default executor
        server.start();
		}catch(Exception e){
			
		}
	}
	
	 static class AllFileNames implements HttpHandler {
	    	@Override
	        public void handle(com.sun.net.httpserver.HttpExchange t) throws IOException {
	            String response = "This is the response";
	            t.sendResponseHeaders(200, response.length());
	            OutputStream os = t.getResponseBody();
	            os.write(response.getBytes());
	            os.close();
	        }
	    }

}
