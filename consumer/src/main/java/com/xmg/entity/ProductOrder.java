package com.xmg.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author makui
 * @created 2022/4/2
 **/
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Date createTime;

    private Date updateTime;

    @PrePersist
    public void setCreateTime() {
        this.createTime = new Date();
    }

    @PreUpdate
    public void setUpdateTime() {
        this.updateTime = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final ProductOrder productOrder = (ProductOrder) o;
        return id != null && Objects.equals(id, productOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
