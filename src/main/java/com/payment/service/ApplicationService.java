package com.payment.service;

import com.payment.converter.ApplicationRequestToApplicationConverter;
import com.payment.dao.ApplicationRepository;
import com.payment.dto.request.CreateApplicationRequest;
import com.payment.dto.response.ApplicationResponse;
import com.payment.entity.Application;
import com.payment.entity.PaymentStatus;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

  private final ApplicationRepository applicationRepository;
  private final ApplicationRequestToApplicationConverter applicationRequestToApplicationConverter;


  public ApplicationService(ApplicationRepository applicationRepository,
                            ApplicationRequestToApplicationConverter applicationRequestToApplicationConverter) {
    this.applicationRepository = applicationRepository;
    this.applicationRequestToApplicationConverter = applicationRequestToApplicationConverter;
  }

  public void save(Application application) {
    applicationRepository.save(application);
  }

  public ApplicationResponse save(CreateApplicationRequest request) {
    Application application = applicationRepository.save(applicationRequestToApplicationConverter.convert(request));
    return new ApplicationResponse<>(application.getId());
  }

  public ApplicationResponse getStatus(Long id) {
    String status = applicationRepository.getPaymentStatus(id);
    return new ApplicationResponse<>(status);
  }

  public Application getApplication() {
    return applicationRepository.findFirstByPaymentStatus(PaymentStatus.NEW);
  }
}
