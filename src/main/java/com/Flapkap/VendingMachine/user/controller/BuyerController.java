package com.Flapkap.VendingMachine.user.controller;

import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.buyer.BuyerBuyingResponse;
import com.Flapkap.VendingMachine.user.dto.request.BuyerBuyingRequest;
import com.Flapkap.VendingMachine.user.dto.request.StoreDepositRequest;
import com.Flapkap.VendingMachine.user.entity.User;
import com.Flapkap.VendingMachine.user.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/buyer")
@Validated
public class BuyerController {
    @Autowired
    BuyerService buyerService;


    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('BUYER')")
    public UserDto deposit(@Validated @RequestBody StoreDepositRequest request) {
        return buyerService.deposit(request);
    }

    @PostMapping("/deposit/reset")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('BUYER')")
    public UserDto reset() {
        return buyerService.reset();
    }

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('BUYER')")
    public BuyerBuyingResponse buy(@Validated @RequestBody BuyerBuyingRequest request) {
        return buyerService.buy(request);
    }


}
