package com.ust.rabbit5.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ust.rabbit.model.OrderStatus;
import com.ust.rabbit.model.entity;

@Component
public class Consumer {
	@RabbitListener(queues="ust_queue")
	public void message1(OrderStatus order) {
		System.out.println("Message is"+order);
	}
	@RabbitListener(queues="oqueue")
	public void message2(entity ent) {
		System.out.println("Message is"+ent);
	}

}
