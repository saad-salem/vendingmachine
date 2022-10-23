package com.Flapkap.VendingMachine.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenUser {
    private Long id;
    private String userName;
    private String role;
    private Integer deposit;
    public TokenUser(Long id,String userName,String role,Integer deposit) {
        this.id=id;
        this.userName=userName;
        this.role=role;
        this.deposit=deposit;
    }
    public TokenUser(Long id,String userName,String role) {
        this.id=id;
        this.userName=userName;
        this.role=role;
    }
}
