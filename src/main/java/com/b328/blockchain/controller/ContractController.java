package com.b328.blockchain.controller;

import com.b328.blockchain.entity.Contract;
import com.b328.blockchain.entity.User;
import com.b328.blockchain.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractController {
    @Autowired
    @Qualifier("ContractService1")
    private ContractService contractService;

    @RequestMapping(value = "/makeContract",method = RequestMethod.POST )
    public int makeContract(@RequestBody Contract contract){
        return contractService.makeContract(contract.getPartyA(),contract.getPartyB(),contract.getContent());
    }

    @RequestMapping(value = "/myAcontract",method = RequestMethod.POST)
    public List<Contract> myAcontract(String partyA){return  contractService.myAcontract(partyA);}

    @RequestMapping(value = "/myBcontract",method = RequestMethod.POST)
    public List<Contract> myBcontract(String partyB){return  contractService.myBcontract(partyB);}

    @RequestMapping(value = "/getAllContract",method = RequestMethod.GET)
    public List<Contract> getAllContract(){return contractService.getAllContract();}

    @RequestMapping(value = "/getContractByID",method = RequestMethod.POST)
    public Contract getContractByID(int id){return  contractService.getContractByID(id);}

    @RequestMapping(value = "/Asigned",method = RequestMethod.POST)
    public int Asigned(@RequestBody Contract contract){
        return  contractService.Asigned(contract.getId());
    }

    @RequestMapping(value = "/Bsigned",method = RequestMethod.POST)
    public int Bsigned(@RequestBody Contract contract){
        return contractService.Bsigned(contract.getId());
    }

    @RequestMapping(value = "/ReviseContract",method = RequestMethod.POST)
    public int ReviseContract(@RequestBody Contract contract){
        return contractService.ReviseContract(contract.getId(),contract.getContent());
    }
}
