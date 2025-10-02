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
package org.example.notification.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Notification {

  @Id
  @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
  private Integer notificationId;

  private Integer toCustomerId;

  private String toCustomerEmail;

  private String sender;

  private String message;

  private LocalDateTime sentAt;
}
