package com.ssau.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "public", catalog = "software_development")
public class CompanyEntity {
  private int companyId;
  private String name;
  private String description;
  private String address;
  private String phone;
  private String site;

  @Id
  @Column(name = "company_id")
  public int getCompanyId() {
    return companyId;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
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
    CompanyEntity that = (CompanyEntity) o;
    return companyId == that.companyId &&
            Objects.equals(name, that.name) &&
            Objects.equals(description, that.description) &&
            Objects.equals(address, that.address) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(site, that.site);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId, name, description, address, phone, site);
  }
}
