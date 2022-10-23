package com.Flapkap.VendingMachine.business.user.service;

import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.buyer.BuyerBuyingResponse;
import com.Flapkap.VendingMachine.business.user.dto.request.BuyerBuyingRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreDepositRequest;

import java.math.BigDecimal;


public interface BuyerService {

    UserDto deposit(StoreDepositRequest request) ;
    UserDto reset() ;
    BuyerBuyingResponse buy(BuyerBuyingRequest request) ;
    void deductUserDeposit(Long id, BigDecimal amount);

}
