package com.example.demo.servise.serviseImpl;

import com.example.demo.pojo.li;
import com.example.demo.mapper.liMapper;
import com.example.demo.servise.UserLi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserLiImpl implements UserLi {

    @Resource
    private liMapper liMapper;
    @Override
    public li GetLiById(Integer id) {
        return liMapper.getLiById(id);
    }

    @Override
    public List<li> getAllLi() {
        return liMapper.getLi();
    }

    @Override
    public int InsertLi(li person) {
        return liMapper.insertLi(person);
    }

    @Override
    public int UpdateLiById(li person) {
        return liMapper.UpdateLiAllByid(person);
    }
}
