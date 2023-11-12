package com.workmexh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.workmexh.domain.PageParam;
import com.workmexh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/Detail")
public class DetailController {

    /*
    * 首页
    *
    *
    * */
    @ResponseBody
    @RequestMapping("/getDetail")
    public Map<String, Object> getAll(PageParam pageParam){

        Map<String,Object> map=new HashMap<>();

        return map;
    }


}
