package br.com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.ms.email.dtos.EmailDto;
import br.com.ms.email.models.EmailModel;
import br.com.ms.email.services.EmailService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailConsumer {
	
	@Autowired
	private EmailService emailService;
	
	@RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
	public void listen(@Payload EmailDto emailDto) {
		
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		
		log.info("Email status " + emailModel.getStatusEmail().toString());
	}

}
