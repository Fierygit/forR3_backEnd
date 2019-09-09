package com.Firefly.forR3.service;


import com.Firefly.forR3.entity.Info;
import com.Firefly.forR3.entity.Usr;

import java.util.List;

public interface InfoService {

    List<Info> getLatesd();

    String addOne(String info);

}
