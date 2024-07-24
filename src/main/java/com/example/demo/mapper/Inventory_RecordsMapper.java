package com.example.demo.mapper;

import com.example.demo.pojo.Inventory_Records;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 16:39
 * desc : mapper
 */
@Mapper
public interface Inventory_RecordsMapper {
    public int AddRecords(Inventory_Records records);
    public Inventory_Records getRecord(Inventory_Records records);
    public List<Inventory_Records> getRecordsByTranDate(String date);

}
