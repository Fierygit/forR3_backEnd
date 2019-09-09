package com.Firefly.forR3.service;
import com.Firefly.forR3.dao.UsrMapper;
import com.Firefly.forR3.entity.Usr;
import com.Firefly.forR3.entity.UsrExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsrServiceImp implements UsrService {

    @Autowired
    UsrMapper usrMapper;

    @Override
    public String addOne(Usr usr){

        Integer uid = usr.getUid();
        UsrExample usrExample = new UsrExample();
        usrExample.createCriteria().andUidEqualTo(uid);
        List<Usr> usrs = usrMapper.selectByExample(usrExample);


        //0存在 1 成功  2 失败
        if(usrs.size() >= 1){
            return "0";
        }
        try{
            usrMapper.insert(usr);
            return "1";
        }catch (Exception e){
            return "2";
        }

    }

}
