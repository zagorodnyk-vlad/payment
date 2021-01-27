package com.payment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //Номер маршрута
  private Long routeNumber;
  //Дата и время отправления
  private Date timeDeparture;
  //Cтатус заявки
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus=PaymentStatus.NEW;
}
