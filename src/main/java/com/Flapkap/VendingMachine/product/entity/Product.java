package com.Flapkap.VendingMachine.product.entity;

import com.Flapkap.VendingMachine.user.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name",unique = true,nullable = false,length = 100)
    private String productName;

    @ColumnDefault(value = "0")
    @Column(name = "amount_available",nullable = false,length = 100)
    private Integer amountAvailable;

    @ColumnDefault(value = "0")
    @Column(nullable = false,length = 100)
    private Double cost;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private User seller;
}
