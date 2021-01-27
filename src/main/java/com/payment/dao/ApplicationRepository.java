package com.payment.dao;

import com.payment.entity.Application;
import com.payment.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

  @Query("select paymentStatus from Application where id=:id")
  String getPaymentStatus(@Param("id")Long id);

  Application findFirstByPaymentStatus(PaymentStatus status);
}
