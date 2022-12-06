package org.example.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    @Column
    private String phone;

    @Column
    private String name;

    @Column
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Status status;

    @OneToMany(mappedBy = "user")
    private List<OrderInfo> orderInfo;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public List<OrderInfo> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(final List<OrderInfo> orderInfo) {
        this.orderInfo = orderInfo;
    }
}
