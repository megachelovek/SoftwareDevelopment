package com.ssau.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carshop", schema = "public", catalog = "software_development")
public class CarshopEntity {
  private int carshopId;
  private String name;
  private String description;
  private String address;
  private String phone;
  private String site;

  @Id
  @Column(name = "carshop_id")
  public int getId() {
    return carshopId;
  }

  public void setId(int carshopId) {
    this.carshopId = carshopId;
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
  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Column(name = "phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Basic
  @Column(name = "site")
  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarshopEntity that = (CarshopEntity) o;
    return carshopId == that.carshopId &&
            Objects.equals(name, that.name) &&
            Objects.equals(description, that.description) &&
            Objects.equals(address, that.address) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(site, that.site);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carshopId, name, description, address, phone, site);
  }
}
