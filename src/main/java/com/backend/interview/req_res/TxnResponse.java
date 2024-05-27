package com.backend.interview.req_res;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TxnResponse {
    private String txnId;
    private String customerName;
    private String service;
    private float amount;
    private float gst;
    private float commission;
}
