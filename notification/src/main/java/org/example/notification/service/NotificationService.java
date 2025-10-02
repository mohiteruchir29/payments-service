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
package org.example.notification.service;

import java.time.LocalDateTime;
import org.example.clients.notification.NotificationRequest;
import org.example.notification.entity.Notification;
import org.example.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  private final NotificationRepository notificationRepository;

  public NotificationService(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  public void sendNotification(NotificationRequest notificationRequest) {
    Notification notification =
        Notification.builder()
            .toCustomerId(notificationRequest.getToCustomerId())
            .message(notificationRequest.getMessage())
            .toCustomerEmail(notificationRequest.getToCustomerName())
            .sender("admin")
            .sentAt(LocalDateTime.now())
            .build();
    notificationRepository.save(notification);
  }
}
