package com.back.office.config;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    @Value("${trade.queue}")
    private String tradeQueue;

    @Value("${trade.exchange}")
    private String tradeExchange;

    @Value("${trade.route.key}")
    private String tradeRoutingKey;

    @Value("${dlq.trade.queue}")
    private String dlqTradeQueue;

    @Value("${dlq.trade.exchange}")
    private String dlqTradeExchange;

    @Value("${dlq.trade.route.key}")
    private String dlqTradeRoutingKey;

    @Bean
    TopicExchange deadLetterExchange() {
        return new TopicExchange(dlqTradeExchange);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(tradeExchange);
    }

    @Bean
    Queue deadLetterQueue() {
        return QueueBuilder.durable(dlqTradeQueue).build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(tradeQueue).withArgument("x-dead-letter-exchange", dlqTradeExchange)
                .withArgument("x-dead-letter-routing-key", dlqTradeRoutingKey).build();
    }

    @Bean
    Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(dlqTradeRoutingKey);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(tradeRoutingKey);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}