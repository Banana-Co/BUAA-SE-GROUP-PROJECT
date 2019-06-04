package com.b328.blockchain.service;

import com.b328.blockchain.entity.Contract;


import java.util.List;

public interface ContractService {
    int makeContract(String partyA,String partyB,String content);
    int Asigned(int id);
    int Bsigned(int id);
    int ReviseContract(int id,String content);
    Contract getContractByID(int id);
    List<Contract> getAllContract();
    List<Contract> myAcontract(String partyA);
    List<Contract> myBcontract(String partyB);
}
