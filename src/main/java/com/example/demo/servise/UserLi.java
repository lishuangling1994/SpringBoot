package com.example.demo.servise;
import com.example.demo.pojo.li;

import java.util.List;

public interface UserLi {
    public li  GetLiById(Integer id);
    public List<li> getAllLi();
    public int InsertLi(li person);
    public int UpdateLiById(li person);
}
