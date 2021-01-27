package com.payment.converter;

import com.payment.dto.request.CreateApplicationRequest;
import com.payment.entity.Application;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRequestToApplicationConverter implements Converter<CreateApplicationRequest, Application> {

  @Override
  public Application convert(CreateApplicationRequest source) {
    Application application = new Application();
    application.setRouteNumber(source.getRouteNumber());
    application.setTimeDeparture(source.getTimeDeparture());

    return application;
  }
}
