package com.pkc.boot.dao;

import com.pkc.boot.bo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountDao {
    /**
     *
     * @mbg.generated 2020-05-15
     */
    long countByExample(AccountExample example);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(Account record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(Account record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    List<Account> selectByExample(AccountExample example);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);
}