package com.distro.Container.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "loc_id")
    private int locId;

    @Column(name = "container_code")
    private String containerCode;

    @Column(name = "loc")
    private String loc;

    @Override
    public String toString() {
        return "Location{" +
                "locId=" + locId +
                ", containerCode='" + containerCode + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Location(int locId, String containerCode, String loc) {
        this.locId = locId;
        this.containerCode = containerCode;
        this.loc = loc;
    }

    public Location() {
    }
}
