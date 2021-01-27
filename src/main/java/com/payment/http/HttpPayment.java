package com.payment.http;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.dto.response.ApplicationResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class HttpPayment {

  public ApplicationResponse getStatus() throws IOException {
    Request request = Request.Get("http://localhost:8081/randomstatus");
    HttpEntity resp = request.execute().returnResponse().getEntity();
    //разбираем ответ
    BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getContent()));
    StringBuilder response = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      response.append(line);
      response.append('\r');
    }
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(response.toString(), ApplicationResponse.class);
  }
}
