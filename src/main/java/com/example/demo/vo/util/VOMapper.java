package com.example.demo.vo.util;

import com.example.demo.entity.Account;
import com.example.demo.vo.AccountCreationVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VOMapper {

    Account toAccount(AccountCreationVO accountCreationVO);

}
