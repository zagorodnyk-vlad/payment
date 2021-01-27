package com.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;


@Data
public class CreateApplicationRequest {

  @NotNull
  private Long routeNumber;

  //Дата и время отправления
  @NotNull
  @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
  private Date timeDeparture;
}
