package com.distro.Container.entity;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(name= "item_name")
    private String itemName;

    @Column(name = "is_flammable")
    private boolean isFlammable;
    @Column(name = "is_fragile")
    private boolean isFragile;
    @Column(name = "is_corrosive")
    private boolean isCorrosive;
    @Column(name = "is_radioactive")
    private boolean isRadioactive;
    @Column(name = "is_explosive")
    private boolean isExplosive;

    public Item() {
    }

    public Item(int itemId, String itemName, boolean isFlammable, boolean isFragile, boolean isCorrosive, boolean isRadioactive, boolean isExplosive) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.isFlammable = isFlammable;
        this.isFragile = isFragile;
        this.isCorrosive = isCorrosive;
        this.isRadioactive = isRadioactive;
        this.isExplosive = isExplosive;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isFlammable() {
        return isFlammable;
    }

    public void setFlammable(boolean flammable) {
        isFlammable = flammable;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public boolean isCorrosive() {
        return isCorrosive;
    }

    public void setCorrosive(boolean corrosive) {
        isCorrosive = corrosive;
    }

    public boolean isRadioactive() {
        return isRadioactive;
    }

    public void setRadioactive(boolean radioactive) {
        isRadioactive = radioactive;
    }

    public boolean isExplosive() {
        return isExplosive;
    }

    public void setExplosive(boolean explosive) {
        isExplosive = explosive;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", isFlammable=" + isFlammable +
                ", isFragile=" + isFragile +
                ", isCorrosive=" + isCorrosive +
                ", isRadioactive=" + isRadioactive +
                ", isExplosive=" + isExplosive +
                '}';
    }
}
