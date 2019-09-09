package com.Firefly.forR3.controller;


import com.Firefly.forR3.entity.Usr;
import com.Firefly.forR3.service.UsrService;
import com.Firefly.forR3.util.IpUtil;
import com.Firefly.forR3.util.Result;
import com.Firefly.forR3.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

@RequestMapping("/usr")
@RestController
@Api(tags = "UsrController")
public class UsrController {


    @Autowired
    UsrService usrService;

    @ApiOperation(value = "新增一个uid")
    @PostMapping("/add")
    public Result<String> add(@RequestParam(value = "uid") int uid, HttpServletRequest request) {
        Usr usr = new Usr();

        usr.setDate(new Date());
        usr.setIp(IpUtil.getIpAddr(request));
        usr.setUid(uid);

        String code = usrService.addOne(usr);
        if (code.contentEquals("0")){
            return ResultUtil.success("用户已经存在");
        }
        else if(code.contentEquals("1")){
            return ResultUtil.success("添加成功");
        }else{
            return ResultUtil.success("服务器错误！！");
        }
    }
}
