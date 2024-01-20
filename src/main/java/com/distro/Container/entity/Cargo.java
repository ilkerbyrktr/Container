package com.distro.Container.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @Column(name = "cargo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cargoId;
    @Column(name = "container_code")
    private String containerCode;

    @Column(name="item_name")
    private String itemName;

    public Cargo(int cargoId, String containerCode, String itemName) {
        this.cargoId = cargoId;
        this.containerCode = containerCode;
        this.itemName = itemName;
    }

    public Cargo() {
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoId=" + cargoId +
                ", containerCode='" + containerCode + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}