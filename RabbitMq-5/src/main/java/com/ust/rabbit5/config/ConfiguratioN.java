package com.ust.rabbit5.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class ConfiguratioN {
	@Value("${order.queue}")
	String queue;
	@Value("${order.exchange}")
	String exchange;
	@Value("${order.routingkey}")
	String routing_key;
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	@Bean
	public Binding binding(Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routing_key);
	}
	/*@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}*/
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionfactory) {
		RabbitTemplate template=new RabbitTemplate(connectionfactory);
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
		
	}
	@Value("${ust.rabbitmq.ust_queue}")
	String queue1;
	@Value("{ust.rabbit.ust_exchange}")
	String exchange1;
	@Value("{ust.rabbit.ust_routing_key}")
	String routingkey1;
	@Bean
	public Queue queue1() {
		return new Queue(queue1);
	}
	@Bean
	public TopicExchange exchange1() {
		return new TopicExchange(exchange1);
	}
	@Bean
	public Binding binding1(Queue queue, TopicExchange exchange) {
		return  BindingBuilder.bind(queue).to(exchange).with(routingkey1);
	}
	@Bean
	public MessageConverter Converter() {
		return new Jackson2JsonMessageConverter();
	}
	@Bean
	public AmqpTemplate tempcreate(ConnectionFactory connectionfactory)
	{
		RabbitTemplate template2=new RabbitTemplate(connectionfactory);
		template2.setMessageConverter(Converter());
		return template2;
	}
	
	

}
