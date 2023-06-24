package com.rabbit.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.MessagingAdviceBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.config.MessagingConfig;
import com.rabbit.model.OrderStatus;
import com.rabbit.model.PurchaseOrder;

@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
	@Autowired
	private RabbitTemplate template;
	@PostMapping("/{customerName}")
	public String bookOrder(@RequestBody PurchaseOrder order,@PathVariable String customerName) {
		order.setOrderId(UUID.randomUUID().toString());
		//other service calls
		OrderStatus orderStatus=new
				OrderStatus(order,"ACCEPTED","order palced successfully by"+
		customerName);
		template.convertAndSend("ust_exchange",
				"ust_routingkey",orderStatus);
		return "succes";
	}

}
