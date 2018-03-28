package com.emall.common.controller;

import com.emall.common.constant.EmallConf;
import com.emall.common.dto.TopCategorizeDto;
import com.emall.common.entity.Categorize;
import com.emall.common.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class PageController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 为用户准备主页
     * */
    @RequestMapping(value = "index")
    public String generateUserIndex(HttpServletRequest request){
        //主菜单信息生成,先从application缓存中找，若没有从数据库找并放入缓存
        ServletContext application = request.getServletContext();
        List<TopCategorizeDto> meunData =
                (List<TopCategorizeDto>) application.getAttribute("meunData");
        if (meunData == null){
            meunData = this.generateMeunData();
            application.setAttribute("meunData", meunData);
        }
        return "index";
    }

    @RequestMapping(value = "checkout")
    public String generateCheckOutPage(){
        return "checkout";
    }

    @RequestMapping(value = "register")
    public String generateRegisterPage(){
        return "register";
    }

    @RequestMapping(value = "login")
    public String generateLoginPage(){
        return "login";
    }

    /**
     * 根据数据库商品类型信息生成网站主菜单
     * */
    private List<TopCategorizeDto> generateMeunData(){
        //获取n个一级分类
        List<Categorize> topNCategorize =
                this.commodityService.listTopCategorize(EmallConf.TOP_CATEGORIZES_NUM);
        int realSize = topNCategorize.size();

        List<TopCategorizeDto> meunDto = new ArrayList<>(realSize);
        //获取每个一级分类下的所有二级分类并放入DTO对象中
        for (int i=0; i<realSize; i++){
            Categorize categorize = topNCategorize.get(i);
            TopCategorizeDto topCategorizeDto = new TopCategorizeDto();

            topCategorizeDto.setId(categorize.getId());
            topCategorizeDto.setName(categorize.getName());

            //二级分类获取
            List<Categorize> subCategorizeList =
                    this.commodityService.listCategorizeByTopCategorize(categorize.getId());
            topCategorizeDto.setSubCategorizes(subCategorizeList);

            meunDto.add(topCategorizeDto);
        }

        return meunDto;
    }
}
