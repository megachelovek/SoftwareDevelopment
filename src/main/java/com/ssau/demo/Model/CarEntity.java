package com.ssau.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "software_development")
public class CarEntity {
  private @Id int carId;
  private String type;
  private Integer capacity;
  private String name;
  private Integer price;
  private Integer maxspeed;
  private String description;

  public CarEntity(int carId, String type, Integer capacity, String name, Integer price,Integer maxspeed,String description) {
    this.carId = carId;
    this.type = type;
    this.capacity = capacity;
    this.name = name;
    this.price = price;
    this.maxspeed = maxspeed;
    this.description = description;
  }

  @Id
  @Column(name = "car_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
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
  @Column(name = "capacity")
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
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
  @Column(name = "price")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Basic
  @Column(name = "maxspeed")
  public Integer getMaxspeed() {
    return maxspeed;
  }

  public void setMaxspeed(Integer maxspeed) {
    this.maxspeed = maxspeed;
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
    CarEntity carEntity = (CarEntity) o;
    return carId == carEntity.carId &&
            Objects.equals(type, carEntity.type) &&
            Objects.equals(capacity, carEntity.capacity) &&
            Objects.equals(name, carEntity.name) &&
            Objects.equals(price, carEntity.price) &&
            Objects.equals(maxspeed, carEntity.maxspeed) &&
            Objects.equals(description, carEntity.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carId, type, capacity, name, price, maxspeed, description);
  }
}
