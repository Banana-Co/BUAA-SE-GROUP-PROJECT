package com.b328.blockchain.controller;

import com.b328.blockchain.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {
    @Autowired
    @Qualifier("ContractService1")
    private ContractService contractService;
}
