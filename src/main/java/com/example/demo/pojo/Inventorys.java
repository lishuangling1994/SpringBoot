package com.example.demo.pojo;

/**
 * @Auror : lsl
 * @Date: 2024-07-23 09:00
 */
public class Inventorys {
    private String inventory_name;
    private String prd_prdcode;
    private int prd_num;

    public Inventorys() {
        super();
    }

    public Inventorys(String inventory_name, String prd_prdcode, int prd_num) {
        this.inventory_name = inventory_name;
        this.prd_prdcode = prd_prdcode;
        this.prd_num = prd_num;
    }

    public String getInventory_name() {
        return inventory_name;
    }

    public void setInventory_name(String inventory_name) {
        inventory_name = inventory_name;
    }

    public String getPrd_prdcode() {
        return prd_prdcode;
    }

    public void setPrd_prdcode(String prd_prdcode) {
        this.prd_prdcode = prd_prdcode;
    }

    public int getPrd_num() {
        return prd_num;
    }

    public void setPrd_num(int prd_num) {
        this.prd_num = prd_num;
    }

    @Override
    public String toString() {
        return "Inventorys{" +
                "Inventory_Name='" + inventory_name + '\'' +
                ", prd_prode='" + prd_prdcode + '\'' +
                ", prd_num=" + prd_num +
                '}';
    }
}
