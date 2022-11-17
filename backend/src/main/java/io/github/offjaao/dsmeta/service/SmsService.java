package io.github.offjaao.dsmeta.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.offjaao.dsmeta.repository.SaleRepository;
import lombok.NoArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service @NoArgsConstructor
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private SaleRepository repository;

	public void sendSms(Long id) {

		val sale = repository.findById(id).get();

		val date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		String rawMessage = String.format(
				"O vendedor %s foi destaque em %s com um total de R$ %.2f",
				sale.getSellerName(), date, sale.getAmount()
		);

		Message message = Message.creator(to, from, rawMessage).create();

		System.out.println(message.getSid());
	}
}