package com.example.demo.pojo;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 16:22
 * desc: 操作明细bean
 */
public class Inventory_Records {
    private String prd_prdcode;
    private String trandate;
    private String transerseqno;
    private int prd_num;
    private String flag;
    private String bei01;
    private String teller;

    public Inventory_Records() {
        super();
    }

    public Inventory_Records(String prd_prdcode, String trandate, String transerseqno,int prd_num, String flag, String bei01, String teller) {
        this.prd_prdcode = prd_prdcode;
        this.trandate = trandate;
        this.transerseqno = transerseqno;
        this.prd_num = prd_num;
        this.flag = flag;
        this.bei01 = bei01;
        this.teller = teller;
    }

    public String getPrd_prdcode() {
        return prd_prdcode;
    }

    public void setPrd_prdcode(String prd_prdcode) {
        this.prd_prdcode = prd_prdcode;
    }

    public String getTrandate() {
        return trandate;
    }

    public void setTrandate(String trandate) {
        this.trandate = trandate;
    }

    public String getTranserseqno() {
        return transerseqno;
    }

    public void setTranserseqno(String transerseqno) {
        this.transerseqno = transerseqno;
    }

    public int getPrd_num() {
        return prd_num;
    }

    public void setPrd_num(int prd_num) {
        this.prd_num = prd_num;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBei01() {
        return bei01;
    }

    public void setBei01(String bei01) {
        this.bei01 = bei01;
    }

    public String getTeller() {
        return teller;
    }

    public void setTeller(String teller) {
        this.teller = teller;
    }

    @Override
    public String toString() {
        return "Inventory_Records{" +
                "prd_code='" + prd_prdcode + '\'' +
                ", trandate='" + trandate + '\'' +
                ", tranSerseqno='" + transerseqno + '\'' +
                ", prd_num='" + prd_num + '\'' +
                ", flag='" + flag + '\'' +
                ", bei01='" + bei01 + '\'' +
                ", teller='" + teller + '\'' +
                '}';
    }
}
