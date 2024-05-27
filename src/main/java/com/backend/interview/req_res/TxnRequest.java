package com.backend.interview.req_res;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TxnRequest {
    @NotBlank(message = "customerName is missing or blank!")
    private String customerName;

    @NotBlank(message = "service is missing or blank!")
    private String service;

    @NotNull(message = "amount is missing!")
    private float amount;

    @NotNull(message = "gst is missing!")
    private float gst;

    @NotNull(message = "commission is missing!")
    private float commission;
}
