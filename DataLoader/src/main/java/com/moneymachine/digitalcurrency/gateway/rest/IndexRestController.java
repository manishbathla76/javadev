package com.moneymachine.digitalcurrency.gateway.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneymachine.digitalcurrency.gateway.LatestQuote;
import com.moneymachine.digitalcurrency.gateway.LatestQuoteCache;
import com.moneymachine.digitalcurrency.gateway.arb.ArbCache;
import com.moneymachine.digitalcurrency.gateway.arb.BestQuote;


@RestController
@RequestMapping("/api")
public class IndexRestController {
	 @RequestMapping("/hello")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
	 
	 
	 @RequestMapping("/latestquote/all")
	    public ArrayList<LatestQuote> getAllLatestQuote() {
	        return LatestQuoteCache.getInstance().getAllQuotes();
	    }
	 
	 @RequestMapping("/bestquote/all")
	    public ArrayList<BestQuote> getAllBestQuote() {
	        return ArbCache.getInstance().getAllQuotes();
	    }

}
