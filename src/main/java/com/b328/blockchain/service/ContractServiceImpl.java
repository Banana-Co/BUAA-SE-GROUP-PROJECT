package com.b328.blockchain.service;

import com.b328.blockchain.entity.Contract;
import com.b328.blockchain.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service("ContractService1")
public  class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public int makeContract(String partyA, String partyB, String content) {
        Contract contract=new Contract();
        contract.setPartyA(partyA);
        contract.setPartyB(partyB);
        contract.setCreateDate(new Date());
        contract.setPartyASigned(false);
        contract.setPartyBSigned(false);
        contract.setContent(content);
        return contractMapper.makeContract(contract);
    }

    @Override
    public Contract getContractByID(int id) {
        return contractMapper.getContractByID(id);
    }

    @Override
    public int ReviseContract(int id, String content) {
        Contract contract=contractMapper.getContractByID(id);
        contract.setContent(content);
        return contractMapper.ReviseContract(contract);
    }

    @Override
    public int Asigned(int id) {
        Contract contract=contractMapper.getContractByID(id);
        contract.setPartyASigned(true);
        return contractMapper.Asigned(contract);
    }

    @Override
    public int Bsigned(int id) {
        Contract contract=contractMapper.getContractByID(id);
        contract.setPartyBSigned(true);
        return contractMapper.Bsigned(contract);
    }

    @Override
    public List<Contract> getAllContract(){
        return contractMapper.getAllContract();
    }


    @Override
    public List<Contract> myAcontract(String partyA) {
        return contractMapper.myAcontract(partyA);
    }

    @Override
    public List<Contract> myBcontract(String partyB) {
        return  contractMapper.myBcontract(partyB);
    }
}
