package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.Contract;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractMapper {

    @Insert("insert into Contract(partyA,partyB,createDate,isPartyASigned,isPartyBSigned,content) " +
            "values(#{partyA}, #{partyB}, #{createDate}, #{isPartyASigned}, #{isPartyBSigned}, #{content})")
    int makeContract(Contract contract);



    @Select("select * from Contract")
    @Results(
            {
                    @Result(property = "id",column = "id"),
                    @Result(property = "partyA",column = "partyA"),
                    @Result(property = "partyB",column = "partyB"),
                    @Result(property = "createDate",column = "createDate"),
                    @Result(property = "isPartyASigned",column = "isPartyASigned"),
                    @Result(property = "isPartyBSigned",column = "isPartyBSigned"),
            }
    )
    List<Contract> getAllContract();

    @Select("select * from Contract where partyA=#{partyA}")
    @Results(
            {
                    @Result(property = "id",column = "id"),
                    @Result(property = "partyA",column = "partyA"),
                    @Result(property = "partyB",column = "partyB"),
                    @Result(property = "createDate",column = "createDate"),
                    @Result(property = "isPartyASigned",column = "isPartyASigned"),
                    @Result(property = "isPartyBSigned",column = "isPartyBSigned"),
                    @Result(property = "content",column = "content")
            }
    )
    List<Contract>myAcontract(String partyA);

    @Select("select * from Contract where partyB=#{partyB}")
    @Results(
            {
                    @Result(property = "id",column = "id"),
                    @Result(property = "partyA",column = "partyA"),
                    @Result(property = "partyB",column = "partyB"),
                    @Result(property = "createDate",column = "createDate"),
                    @Result(property = "isPartyASigned",column = "isPartyASigned"),
                    @Result(property = "isPartyBSigned",column = "isPartyBSigned"),
                    @Result(property = "content",column = "content")
            }
    )
    List<Contract>myBcontract(String partyB);

    @Select("select * from Contract where id=#{id}")
    @Results(
            {
                    @Result(property = "id",column = "id"),
                    @Result(property = "partyA",column = "partyA"),
                    @Result(property = "partyB",column = "partyB"),
                    @Result(property = "createDate",column = "createDate"),
                    @Result(property = "isPartyASigned",column = "isPartyASigned"),
                    @Result(property = "isPartyBSigned",column = "isPartyBSigned"),
                    @Result(property = "content",column = "content")
            }
    )
    Contract getContractByID(int id);

    @Update("update Contract set isPartyASigned=true where id=#{id}")
    int Asigned(Contract contract);

    @Update("update Contract set isPartyBSigned=true where id=#{id}")
    int Bsigned(Contract contract);

    @Update("update Contract set content=#{content} where id=#{id}")
    int ReviseContract(Contract contract);
}
