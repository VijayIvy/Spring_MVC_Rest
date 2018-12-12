package com.cts.nm.test;

import org.springframework.web.client.RestTemplate;

import com.cts.nm.model.MailDetails;

public class TestRestClient {

	public static void main(String[] args) {
		String uri = "http://localhost:8080/NMJMLMailService/callMailServiceTest";
		MailDetails l_objMailservice = new MailDetails();
		l_objMailservice.setToMail("FromBhabesh.ChandraMohanta@cognizant.com");
		//l_objMailservice.setFromMail("ToBhabesh.ChandraMohanta@cognizant.com");
		RestTemplate restTemplate = new RestTemplate();
		MailDetails result = restTemplate.postForObject(uri, l_objMailservice, MailDetails.class);
		//System.out.println(result.getFromMail());
		System.out.println(result.getToMail());
	}

}
