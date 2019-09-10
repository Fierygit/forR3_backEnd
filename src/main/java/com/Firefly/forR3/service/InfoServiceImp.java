package com.Firefly.forR3.service;

import com.Firefly.forR3.dao.InfoMapper;
import com.Firefly.forR3.dao.UsrMapper;
import com.Firefly.forR3.entity.Info;
import com.Firefly.forR3.entity.InfoExample;
import com.Firefly.forR3.entity.Usr;
import com.Firefly.forR3.entity.UsrExample;
import com.Firefly.forR3.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;


@Service
public class InfoServiceImp implements InfoService {

    @Autowired
    InfoMapper infoMapper;
    @Autowired
    UsrMapper usrMapper;


    @Override
    public List<Info> getLatesd() {
        InfoExample infoExample = new InfoExample();
        infoExample.createCriteria().andIdIsNotNull();
        List<Info> infos = infoMapper.selectByExample(infoExample);

        infos.sort((Info o1, Info o2) -> (o1.getDate1().getTime() - o2.getDate1().getTime()) >= 0 ? -1 : 1);
        //   new Comparator<ProductionBatchInfo>() {
//            @Override
//            public int compare(ProductionBatchInfo o1, ProductionBatchInfo o2) {
//                return (o1.getStartTime().getTime() - o2.getStartTime().getTime() ) >= 0 ?  1 : -1;
//            }
//        }
        List<Info> inf = new ArrayList<>();
        for (int i = 0; i < 5 && i < infos.size(); i++) {//获取最近的五个
            inf.add(infos.get(i));
        }
        return inf;
    }

    @Override
    public String addOne(String info) {
        InfoExample infoExample = new InfoExample();
        infoExample.createCriteria().andInfoEqualTo(info);
        List<Info> infos = infoMapper.selectByExample(infoExample);
        if (infos.size() == 0) {
            //如果没有就增加一条，新增一条记录
            Info inf = new Info();
            inf.setDate1(new Date());
            inf.setInfo(info);
            infoMapper.insert(inf);
        }

        //给所有玩家 兑换
        UsrExample usrExample = new UsrExample();
        usrExample.createCriteria().andUidIsNotNull();
        List<Usr> usrs = usrMapper.selectByExample(usrExample);
        StringBuilder temp = new StringBuilder();
        for (Usr usr : usrs) {
            int uid = usr.getUid();
            // 开启新的线程 不开  不开
            //new Thread( temp += HttpUtil.SendGet(String.valueOf(uid),info) ).start();//这里进行请求
            // new Thread().start();
            temp.append("uid").append(uid).append(HttpUtil.SendGet(String.valueOf(uid), info));
        }
        // System.out.println("success");
        //  System.out.println(temp);
        return temp.toString();
    }

}
