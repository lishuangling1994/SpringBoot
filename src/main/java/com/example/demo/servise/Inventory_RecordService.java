package com.example.demo.servise;

import com.example.demo.pojo.Inventory_Records;

import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 17:05
 */
public interface Inventory_RecordService {
    public int InsertRecord(Inventory_Records records);
    public List<Inventory_Records> getRecordsByDate(String trandate);
    public Inventory_Records getRecord(String trandate,String serseqno);
}
