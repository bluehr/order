package cn.hr.order.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author fys2000
 * @date 2019/1/28 10:07
 * @description
 */
@Entity
@Table(name = "order_master")
public class OrderMaster {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "buyer_name")
    private String buyerName;
    @Column(name = "buyer_phone")
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    @Basic
    @Column(name = "buyer_address")
    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    @Basic
    @Column(name = "buyer_openid")
    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    @Basic
    @Column(name = "order_amount")
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "order_status")
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "pay_status")
    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderMaster that = (OrderMaster) o;
        return orderStatus == that.orderStatus &&
                payStatus == that.payStatus &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(buyerName, that.buyerName) &&
                Objects.equals(buyerPhone, that.buyerPhone) &&
                Objects.equals(buyerAddress, that.buyerAddress) &&
                Objects.equals(buyerOpenid, that.buyerOpenid) &&
                Objects.equals(orderAmount, that.orderAmount) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, buyerName, buyerPhone, buyerAddress, buyerOpenid, orderAmount, orderStatus, payStatus, createTime, updateTime);
    }
}
