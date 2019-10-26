package com.ssau.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductCarEntityPK implements Serializable {
  private int carshopId;
  private int carId;

  @Column(name = "carshop_id")
  @Id
  public int getCarshopId() {
    return carshopId;
  }

  public void setCarshopId(int carshopId) {
    this.carshopId = carshopId;
  }

  @Column(name = "car_id")
  @Id
  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductCarEntityPK that = (ProductCarEntityPK) o;
    return carshopId == that.carshopId &&
            carId == that.carId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carshopId, carId);
  }
}
