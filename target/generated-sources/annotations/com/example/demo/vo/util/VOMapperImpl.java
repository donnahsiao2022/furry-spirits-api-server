package com.example.demo.vo.util;

import com.example.demo.entity.Account;
import com.example.demo.vo.AccountCreationVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-08T15:52:57+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Homebrew)"
)
@Component
public class VOMapperImpl implements VOMapper {

    @Override
    public Account toAccount(AccountCreationVO accountCreationVO) {
        if ( accountCreationVO == null ) {
            return null;
        }

        Account account = new Account();

        account.setName( accountCreationVO.getName() );

        return account;
    }
}
