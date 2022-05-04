package com.example.shoppingcartservice.dao.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "cart_event", indexes = {
    @Index(name = "IDX_CART_EVENT_USER", columnList = "id,userId")})
@Entity
public class CartEvent extends BaseEntity {

  @Id
  @GeneratedValue
  private Long id;
  @Enumerated(EnumType.STRING)
  private CartEventType cartEventType;
  private Long userId;
  private String productId;
  private Integer quantity;

  public CartEvent() {
  }

  public CartEvent(CartEventType cartEventType, Long userId) {
    this.cartEventType = cartEventType;
    this.userId = userId;
  }

  public CartEvent(CartEventType cartEventType, Long userId, String productId, Integer quantity) {
    this.cartEventType = cartEventType;
    this.userId = userId;
    this.productId = productId;
    this.quantity = quantity;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CartEventType getCartEventType() {
    return cartEventType;
  }

  public void setCartEventType(CartEventType cartEventType) {
    this.cartEventType = cartEventType;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public enum CartEventType {
    ADD_ITEM,
    REMOVE_ITEM,
    CLEAR_CART,
    CHECKOUT
  }
}
