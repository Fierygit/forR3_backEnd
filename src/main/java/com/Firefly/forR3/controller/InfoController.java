package com.Firefly.forR3.controller;


import com.Firefly.forR3.entity.Info;
import com.Firefly.forR3.entity.Usr;
import com.Firefly.forR3.service.InfoService;
import com.Firefly.forR3.service.UsrService;
import com.Firefly.forR3.util.IpUtil;
import com.Firefly.forR3.util.Result;
import com.Firefly.forR3.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RequestMapping("/Info")
@RestController
@Api(tags = "InfoController")
public class InfoController {


    @Autowired
    InfoService infoService;

    @ApiOperation(value = "新增一个uid")
    @PostMapping("/getLatesd")
    public Result<List<Info>> getLatesd() {
        return ResultUtil.success(infoService.getLatesd());
    }

    @ApiOperation(value = "兑换兑换码")
    @PostMapping("/addOne")
    public Result<String> addOne(String info) {
        return ResultUtil.success(infoService.addOne(info));
    }


}




















