package com.ssau.demo.Controller;

import com.ssau.demo.Entity.CarEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "car")
public class CarXSL {
  private List<CarEntity> cars;

  public CarXSL(List<CarEntity> cars) {
    this.cars = cars;
  }
  @XmlElement(name = "doc")
  public List<CarEntity> getAll() {
    return cars;
  }
}
