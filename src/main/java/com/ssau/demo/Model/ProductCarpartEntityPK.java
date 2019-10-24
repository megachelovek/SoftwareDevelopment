package com.ssau.demo.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductCarpartEntityPK implements Serializable {
  private int carshopId;
  private int carpartId;

  @Column(name = "carshop_id")
  @Id
  public int getCarshopId() {
    return carshopId;
  }

  public void setCarshopId(int carshopId) {
    this.carshopId = carshopId;
  }

  @Column(name = "carpart_id")
  @Id
  public int getCarpartId() {
    return carpartId;
  }

  public void setCarpartId(int carpartId) {
    this.carpartId = carpartId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductCarpartEntityPK that = (ProductCarpartEntityPK) o;
    return carshopId == that.carshopId &&
            carpartId == that.carpartId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carshopId, carpartId);
  }
}
