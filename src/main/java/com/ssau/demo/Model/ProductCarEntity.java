package com.ssau.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_car", schema = "public", catalog = "software_development")
@IdClass(ProductCarEntityPK.class)
public class ProductCarEntity {
  private int carshopId;
  private int carId;
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
  @Column(name = "car_id")
  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
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
    ProductCarEntity that = (ProductCarEntity) o;
    return carshopId == that.carshopId &&
            carId == that.carId &&
            amount == that.amount &&
            price == that.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carshopId, carId, amount, price);
  }
}
