package com.cts.nm.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cts.nm.model.MailDetails;

@Component
@Scope("prototype")
public class EmailUtil {

	public void sendEmail(MailDetails p_objMailDetails) {
		try {
			String uri = "http://localhost:8080/NMJMLMailService/callMailServiceTest";
			RestTemplate restTemplate = new RestTemplate();
			MailDetails result = restTemplate.postForObject(uri, p_objMailDetails, MailDetails.class);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("sendEmail Exception" + e);
		}
	}
}
