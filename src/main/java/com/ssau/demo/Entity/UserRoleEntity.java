package com.ssau.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "public", catalog = "software_development")
public class UserRoleEntity {
  private int id;
  private String name;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public UserRoleEntity(){
  }

  public enum UserRoleType {
    USER,
    ADMIN
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserRoleEntity(int id,String name){
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserRoleEntity that = (UserRoleEntity) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
