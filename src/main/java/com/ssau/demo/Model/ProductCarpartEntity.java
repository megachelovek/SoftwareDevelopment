package com.ssau.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_carpart", schema = "public", catalog = "software_development")
@IdClass(ProductCarpartEntityPK.class)
public class ProductCarpartEntity {
  private int carshopId;
  private int carpartId;
  private int amount;
  private int price;

  @Id
  @Column(name = "carshop_id")
  public int getCarshopId() {
    return carshopId;
  }

  public void setCarshopId(int carshopId) {
    this.carshopId = carshopId;
  }

  @Id
  @Column(name = "carpart_id")
  public int getCarpartId() {
    return carpartId;
  }

  public void setCarpartId(int carpartId) {
    this.carpartId = carpartId;
  }

  @Basic
  @Column(name = "amount")
  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Basic
  @Column(name = "price")
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductCarpartEntity that = (ProductCarpartEntity) o;
    return carshopId == that.carshopId &&
            carpartId == that.carpartId &&
            amount == that.amount &&
            price == that.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carshopId, carpartId, amount, price);
  }
}
