package com.example.demo.servise;

import com.example.demo.pojo.Inventorys;

import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-23 09:55
 */
public interface InventoryService {
    public List<Inventorys> getAllInventorys();
    public List<Inventorys> getInventorysByName(String invent_name);
    public Inventorys getInventorysByPrdCode(Inventorys inventorys);
    public int  AddInventorys(Inventorys inventory);
    public int  ModifyInventorys(Inventorys inventory);

}
