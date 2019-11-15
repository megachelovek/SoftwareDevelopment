package com.ssau.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carpart", schema = "public", catalog = "software_development")
public class CarpartEntity {
  private int carpartId;
  private Integer lifetime;
  private Integer price;
  private String name;
  private String type;
  private String description;

  @Id
  @Column(name = "carpart_id")
  public int getId() {
    return carpartId;
  }

  public void setId(int carpartId) {
    this.carpartId = carpartId;
  }

  @Basic
  @Column(name = "lifetime")
  public Integer getLifetime() {
    return lifetime;
  }

  public void setLifetime(Integer lifetime) {
    this.lifetime = lifetime;
  }

  @Basic
  @Column(name = "price")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Basic
  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarpartEntity that = (CarpartEntity) o;
    return carpartId == that.carpartId &&
            Objects.equals(lifetime, that.lifetime) &&
            Objects.equals(price, that.price) &&
            Objects.equals(name, that.name) &&
            Objects.equals(type, that.type) &&
            Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carpartId, lifetime, price, name, type, description);
  }
}
