package com.backend.interview.controller;

import com.backend.interview.entity.Txn;
import com.backend.interview.req_res.TxnRequest;
import com.backend.interview.req_res.TxnResponse;
import com.backend.interview.service.TxnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("txn")
@RequiredArgsConstructor
public class TxnController {
    private final TxnService service;

    @PostMapping("/add")
    public ResponseEntity<TxnResponse> addTxn(@Valid @RequestBody TxnRequest request){
        return ResponseEntity.ok().body(service.addTxn(request));
    }

    @GetMapping("/amount/{initial_range}/{final_range}")
    public ResponseEntity<?> getTxnsByAmountRange(
            @PathVariable float initial_range,
            @PathVariable float final_range
    ) {
        List<Txn> txns = service.getTxnsByAmountRange(initial_range, final_range);

        if (txns.isEmpty()) {
            return ResponseEntity.status(400).body("No transactions found in the specified range!");
        }

        return ResponseEntity.ok().body(txns);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<?> getAllTxnsSortedByAmount() {
        List<Txn> txns = service.getAllTxnsSortedByAmount();

        if (txns.isEmpty()) {
            return ResponseEntity.status(400).body("No transactions found!");
        }

        return ResponseEntity.ok().body(txns);
    }
}
