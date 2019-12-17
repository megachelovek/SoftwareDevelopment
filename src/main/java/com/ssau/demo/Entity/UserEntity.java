package com.ssau.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "user", schema = "public", catalog = "software_development")
public class UserEntity {
  private String username;
  private String password;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
  private Set<UserRoleEntity> roles = new HashSet<>();

//  public Set<UserRoleEntity> getRoles() {
//   return this.roles;
//  }

  public void setRoles(Set<UserRoleEntity> roles) {
    this.roles = roles;
  }

  public UserEntity() {
  }

  public UserEntity(@NotBlank @Size(max = 15) String username, @NotBlank @Size(max = 100) String password) {
    this.username = username;
    this.password = password;
  }

  @Basic
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Id
  @Column(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Basic
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserEntity that = (UserEntity) o;

    if (username != null ? !username.equals(that.username) : that.username != null) return false;
    if (password != null ? !password.equals(that.password) : that.password != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = username != null ? username.hashCode() : 0;
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }

  public enum UserRoleType {
    USER,
    ADMIN
  }
}
