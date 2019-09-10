package com.Firefly.forR3.controller;


import com.Firefly.forR3.entity.Info;
import com.Firefly.forR3.entity.InfoDTO;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public Result<List<InfoDTO>> getLatesd() {

        List<InfoDTO> re = new ArrayList<>();
        List<Info> latesd = infoService.getLatesd();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Info i : latesd) {
            InfoDTO infoDTO = new InfoDTO(i.getId(), i.getInfo(), formatter.format(i.getDate1()));
            re.add(infoDTO);
        //    System.out.println(infoDTO.getDate());
        }

        return ResultUtil.success(re);
    }

    @ApiOperation(value = "兑换兑换码")
    @PostMapping("/addOne")
    public Result<String> addOne(String info) {
        return ResultUtil.success(infoService.addOne(info));
    }


}




















