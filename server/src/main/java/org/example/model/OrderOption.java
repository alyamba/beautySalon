package org.example.model;

import javax.persistence.*;

@Entity
@Table
public class OrderOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "optionId", referencedColumnName = "id")
    private Selection selection;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private OrderInfo orderInfo;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Selection getOption() {
        return selection;
    }

    public void setOption(final Selection selection) {
        this.selection = selection;
    }

    public OrderInfo getOrder() {
        return orderInfo;
    }

    public void setOrder(final OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
