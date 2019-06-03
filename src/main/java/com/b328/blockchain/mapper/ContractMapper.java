package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.Contract;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractMapper {
    @Insert("INSERT INTO Contract(party_a, party_b, create_date, party_a_status, party_b_status, content)" +
            "VALUES(#{partyA}, #{partyB}, #{createDate}, #{isPartyASigned}, #{isPartyBSigned}, #{content})")
    int addContract(Contract contract);
}
