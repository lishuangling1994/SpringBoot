package com.example.demo.servise.serviseImpl;

import com.example.demo.Tool.SequenceUntis;
import com.example.demo.mapper.Inventory_RecordsMapper;
import com.example.demo.mapper.PrdInfoMapper;
import com.example.demo.pojo.Inventory_Records;
import com.example.demo.pojo.Inventorys;
import com.example.demo.pojo.PrdInfo;
import com.example.demo.servise.InventoryService;
import com.example.demo.servise.Inventory_RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 17:27
 */
@Service
public class Inventory_RecordServiceImpl implements Inventory_RecordService{

    private static final Logger log= LoggerFactory.getLogger(Inventory_RecordServiceImpl.class);

    @Resource
    private Inventory_RecordsMapper inventory_recordsMapper;
    @Resource
    private PrdInfoMapper prdInfoMapper;
    @Resource
    private InventoryService inventoryService;
    HttpServletRequest request;

    @Override
    @Transactional
    public int InsertRecord(Inventory_Records records) {

        int record_num=Integer.valueOf(records.getPrd_num()); //本次入库数量
        String Flag=records.getFlag();//获取出入库标志
        String Prdcode=records.getPrd_prdcode();//获取出入库的产品编码
        /*用上传的产品信息，检验产品信息是否存在系统*/
        PrdInfo prdInfo_record=new PrdInfo();
        prdInfo_record.setPrd_prdcode(Prdcode);
        PrdInfo DBprdInfo=prdInfoMapper.getPrdInfo(prdInfo_record);
        if(StringUtils.isEmpty(DBprdInfo)){
            log.info("入库的产品不存在，请先添加产品"+Prdcode);
            return 0;
        }
        /*生成日期和流水号插入出入库明细表*/
        Date date=new Date();
        SimpleDateFormat sm=new SimpleDateFormat("YYYY-MM-dd");
        String TranDate=sm.format(date);
        records.setTrandate(TranDate);
        //records.setTeller(request.getSession().getAttribute("username").toString());
        String serseqno=SequenceUntis.getSeqSeqNo();
        records.setTranserseqno(serseqno);
        inventory_recordsMapper.AddRecords(records);

        /*入库*/
        if(Flag.equals("0")){
            /*创建库存详情对象插入库存详情*/
            Inventorys inventorys=new Inventorys(records.getBei01(),Prdcode,record_num);
            /*查询库存中是否有对应的产品，有的话更新没有的话新增*/
            Inventorys DbInventory=inventoryService.getInventorysByPrdCode(inventorys);
            if(StringUtils.isEmpty(DbInventory)) {
                inventoryService.AddInventorys(inventorys);
            }else {
                int DbRecord_num=Integer.valueOf(DbInventory.getPrd_num());
                DbInventory.setPrd_num(record_num+DbRecord_num);
                inventoryService.ModifyInventorys(DbInventory);
            }

        } else if (Flag.equals("1")){
            /*创建库存详情对象去验证是否可以出库*/
            Inventorys inventorys1=new Inventorys(records.getBei01(),Prdcode,record_num);
            /*查询库存中是否有对应的产品，没有的话不能出库*/
            Inventorys DbInventory1=inventoryService.getInventorysByPrdCode(inventorys1);
            if(!StringUtils.isEmpty(DbInventory1)) {
                int DbRecord_num=Integer.valueOf(DbInventory1.getPrd_num());
                if(DbRecord_num>record_num){
                    DbInventory1.setPrd_num(DbRecord_num-record_num);
                    inventoryService.ModifyInventorys(DbInventory1);                }
            }else {
                log.info(records.getBei01()+Prdcode+"库存不足!");
                return -1;
            }

        } else {
            log.info("出入库标志错误");
            return -1;
        }
        return 0;
    }

    @Override
    public List<Inventory_Records> getRecordsByDate(String trandate) {
        return inventory_recordsMapper.getRecordsByTranDate(trandate);
    }

    @Override
    public Inventory_Records getRecord(String trandate, String serseqno) {
        Inventory_Records inventory_records=new Inventory_Records();
        inventory_records.setTrandate(trandate);
        inventory_records.setTranserseqno(serseqno);
        return inventory_recordsMapper.getRecord(inventory_records);
    }
}
