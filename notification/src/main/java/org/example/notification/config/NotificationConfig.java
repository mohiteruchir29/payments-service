/*
 * Copyright (C) YEAR Your Company
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.notification.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class NotificationConfig {

  @Value("${rabbitmq.exchanges.internal}")
  private String internalExchange;

  @Value("${rabbitmq.queues.notification}")
  private String notificationQueue;

  @Value("${rabbitmq.routing-keys.internal-notification}")
  private String internalNotificationRoutingKey;

  @Bean
  public TopicExchange internalTopicExchange() {
    return new TopicExchange(this.internalExchange);
  }

  @Bean
  public Queue notificationQueue() {
    return new Queue(this.notificationQueue);
  }

  @Bean
  public Binding internalNotificationBinding() {
    return BindingBuilder.bind(notificationQueue())
        .to(internalTopicExchange())
        .with(internalNotificationRoutingKey);
  }
}
