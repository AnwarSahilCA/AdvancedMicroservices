package com.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.config.MessagingConfig;
import com.rabbit.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
	@RabbitListener(queues="ust_queue")
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("MEssage received from queue:"+
	orderStatus);
	}

}
