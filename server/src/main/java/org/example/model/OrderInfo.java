package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "orderInfo")
    private List<OrderOption> orderOptions;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private UserEntity user;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public List<OrderOption> getOrderItems() {
        return orderOptions;
    }

    public void setOrderItems(final List<OrderOption> orderOptions) {
        this.orderOptions = orderOptions;
    }

    public List<OrderOption> getOrderOptions() {
        return orderOptions;
    }

    public void setOrderOptions(final List<OrderOption> orderOptions) {
        this.orderOptions = orderOptions;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(final UserEntity user) {
        this.user = user;
    }
}
