package com.example.demo.servise.serviseImpl;

import com.example.demo.mapper.InventorysMaper;
import com.example.demo.pojo.Inventorys;
import com.example.demo.servise.InventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-23 09:56
 * desc : 库存详情
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Resource
    private InventorysMaper inventorysMaper;

    @Override
    public List<Inventorys> getAllInventorys() {
        return inventorysMaper.getAllInventorys();
    }

    @Override
    public List<Inventorys> getInventorysByName(String invent_name) {
        return inventorysMaper.getInventorysByName(invent_name);
    }

    @Override
    public int AddInventorys(Inventorys inventory) {
        return inventorysMaper.AddInventorys(inventory);
    }

    @Override
    public int ModifyInventorys(Inventorys inventory) {
        return inventorysMaper.ModifyInventorys(inventory);
    }

    @Override
    public Inventorys getInventorysByPrdCode(Inventorys inventorys) {
        return inventorysMaper.getInventorysByPrdCode(inventorys);
    }
}
