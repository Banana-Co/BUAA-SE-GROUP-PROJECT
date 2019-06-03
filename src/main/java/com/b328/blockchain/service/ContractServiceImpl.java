package com.b328.blockchain.service;

import com.b328.blockchain.entity.Contract;
import com.b328.blockchain.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("ContractService1")
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractMapper contractMapper;

    @Override
    public int addContract(String partyA, String partyB, String content) {
        Contract contract = new Contract();

        contract.setPartyA(partyA);
        contract.setPartyB(partyB);
        contract.setCreateDate(new Date());
        contract.setPartyASigned(false);
        contract.setPartyBSigned(false);
        contract.setContent(content);

        return contractMapper.addContract(contract);
    }
}
