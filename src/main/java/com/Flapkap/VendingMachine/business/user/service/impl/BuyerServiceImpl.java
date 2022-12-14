package com.Flapkap.VendingMachine.business.user.service.impl;

import com.Flapkap.VendingMachine.util.SecurityUtils;
import com.Flapkap.VendingMachine.business.product.entity.Product;
import com.Flapkap.VendingMachine.business.product.service.ProductMapper;
import com.Flapkap.VendingMachine.business.product.service.ProductService;
import com.Flapkap.VendingMachine.business.user.dto.TokenUser;
import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.buyer.BuyerBuyingResponse;
import com.Flapkap.VendingMachine.business.user.dto.request.BuyerBuyingRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreDepositRequest;
import com.Flapkap.VendingMachine.business.user.entity.User;
import com.Flapkap.VendingMachine.business.user.exceptions.UserNotFoundException;
import com.Flapkap.VendingMachine.business.user.repo.UserRepository;
import com.Flapkap.VendingMachine.business.user.service.BuyerService;
import com.Flapkap.VendingMachine.business.user.service.UserMapper;
import com.Flapkap.VendingMachine.business.user.service.UserService;
import com.Flapkap.VendingMachine.business.user.validator.buyer.BuyerShouldHaveEnoughDeposit;
import com.Flapkap.VendingMachine.business.user.validator.buyer.DepositAmountShouldBeCorrect;
import com.Flapkap.VendingMachine.business.user.validator.buyer.ProductShouldHaveSufficientStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductService productService;

    @Override
    public UserDto deposit(StoreDepositRequest request) {
        new DepositAmountShouldBeCorrect(request.getDeposit()).validateOrThrow();
        TokenUser tokenUser = SecurityUtils.getTokenUser();
        User user = userService.getUserById(tokenUser.getId());
        user.setDeposit(request.getDeposit());
        userRepository.save(user);
        return userMapper.map(user);
    }
    @Override
    public UserDto reset() {
        TokenUser tokenUser = SecurityUtils.getTokenUser();
        User user = userService.getUserById(tokenUser.getId());
        user.setDeposit(BigDecimal.ZERO);
        userRepository.save(user);
        return userMapper.map(user);
    }
    @Override
    @Transactional
    public BuyerBuyingResponse buy(BuyerBuyingRequest request) {
        TokenUser tokenUser = SecurityUtils.getTokenUser();
        User user = userService.getUserById(tokenUser.getId());
        Product product = productService.getProduct(request.getProductId());
        new ProductShouldHaveSufficientStock(request, product).validateOrThrow();
        BigDecimal orderTotalPrice = BigDecimal.valueOf(request.getAmount() * product.getCost());
        new BuyerShouldHaveEnoughDeposit(request, product, user).validateOrThrow();
        productService.deductProductAmount(request.getProductId(), request.getAmount());
        deductUserDeposit(tokenUser.getId(), orderTotalPrice);
        return new BuyerBuyingResponse(orderTotalPrice, request.getProductId(), user.getDeposit());
    }
    @Override
    public void deductUserDeposit(Long id, BigDecimal amount) {
        User entity = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        entity.setDeposit(entity.getDeposit().subtract(amount));
        userRepository.save(entity);
    }
}
