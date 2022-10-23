package com.Flapkap.VendingMachine.user.service;

import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.buyer.BuyerBuyingResponse;
import com.Flapkap.VendingMachine.user.dto.request.BuyerBuyingRequest;
import com.Flapkap.VendingMachine.user.dto.request.StoreDepositRequest;
import com.Flapkap.VendingMachine.user.entity.User;

import java.math.BigDecimal;
import java.util.Optional;


public interface BuyerService {

    UserDto deposit(StoreDepositRequest request) ;
    UserDto reset() ;
    BuyerBuyingResponse buy(BuyerBuyingRequest request) ;
    void deductUserDeposit(Long id, BigDecimal amount);

}
