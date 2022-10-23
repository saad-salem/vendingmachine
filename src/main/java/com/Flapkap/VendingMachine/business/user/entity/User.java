package com.Flapkap.VendingMachine.business.user.entity;

import com.Flapkap.VendingMachine.business.product.entity.Product;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,length = 100)
    private String userName;

    @Column(nullable = false,length = 100)
    private String password;

//    @ColumnDefault(value = "BUYER")
    @Column
    private Role role;

    @ColumnDefault(value = "0")
    @Column(length = 100)
    private BigDecimal deposit;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public User(Long id) {
        this.id = id;
    }

}
