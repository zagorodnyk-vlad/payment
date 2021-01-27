package com.payment.controller;

import com.payment.dto.request.CreateApplicationRequest;
import com.payment.dto.response.ApplicationResponse;
import com.payment.entity.PaymentStatus;
import com.payment.http.HttpPayment;
import com.payment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;


@RestController
public class ApplicationController {

  @Autowired
  HttpPayment httpPayment;

  private final ApplicationService applicationService;

  public ApplicationController(ApplicationService applicationService) {
    this.applicationService = applicationService;
  }

  @PostMapping("/save")
  public ResponseEntity<ApplicationResponse> save(@RequestBody @Valid CreateApplicationRequest createApplicationRequest) {
    return ResponseEntity.status(HttpStatus.OK).body(applicationService.save(createApplicationRequest));
  }

  @GetMapping("/getstatus")
  public ResponseEntity<ApplicationResponse> getStatus(@RequestParam Long id) throws IOException {
    httpPayment.getStatus();
    return ResponseEntity.status(HttpStatus.OK).body(applicationService.getStatus(id));
  }

  @GetMapping("/randomstatus")
  public ResponseEntity<ApplicationResponse> getRandomStatus() {
    return ResponseEntity.status(HttpStatus.OK).body(new ApplicationResponse<>(PaymentStatus.generateRandomStatus().toString()));
  }
}
