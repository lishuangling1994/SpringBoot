package com.example.demo.pojo;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 15:11
 */
public class PrdInfo {
    private String prd_prdcode;
    private String prd_prdname;
    private Double prd_price;
    private String prd_desc;
    private String prd_bei01;
    private String prd_status;

    @Override
    public String toString() {
        return "PrdInfo{" +
                "prd_prdcode='" + prd_prdcode + '\'' +
                ", prd_prdname='" + prd_prdname + '\'' +
                ", prd_price=" + prd_price +
                ", prd_desc='" + prd_desc + '\'' +
                ", prd_bei01='" + prd_bei01 + '\'' +
                ", prd_status='" + prd_status + '\'' +
                '}';
    }

    public String getPrd_status() {
        return prd_status;
    }

    public void setPrd_status(String prd_status) {
        this.prd_status = prd_status;
    }

    public PrdInfo() {
    }

    public PrdInfo(String prd_prdcode, String prd_prdname, Double prd_price, String prd_desc, String prd_bei01, String prd_status) {
        this.prd_prdcode = prd_prdcode;
        this.prd_prdname = prd_prdname;
        this.prd_price = prd_price;
        this.prd_desc = prd_desc;
        this.prd_bei01 = prd_bei01;
        this.prd_status = prd_status;
    }

    public String getPrd_prdcode() {
        return prd_prdcode;
    }

    public void setPrd_prdcode(String prd_prdcode) {
        this.prd_prdcode = prd_prdcode;
    }

    public String getPrd_prdname() {
        return prd_prdname;
    }

    public void setPrd_prdname(String prd_prdname) {
        this.prd_prdname = prd_prdname;
    }

    public Double getPrd_price() {
        return prd_price;
    }

    public void setPrd_price(Double prd_price) {
        this.prd_price = prd_price;
    }

    public String getPrd_desc() {
        return prd_desc;
    }

    public void setPrd_desc(String prd_desc) {
        this.prd_desc = prd_desc;
    }

    public String getPrd_bei01() {
        return prd_bei01;
    }

    public void setPrd_bei01(String prd_bei01) {
        this.prd_bei01 = prd_bei01;
    }

}
