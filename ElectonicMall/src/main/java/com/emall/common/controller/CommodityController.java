package com.emall.common.controller;

import com.emall.common.constant.EmallConf;
import com.emall.common.dto.PageDto;
import com.emall.common.entity.Categorize;
import com.emall.common.entity.Commodity;
import com.emall.common.entity.EmallUser;
import com.emall.common.service.CategorizeService;
import com.emall.common.service.CommodityService;
import com.emall.recomd.service.impl.UserBehaviorRecorder;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 商品模块Controller
 * */
@Controller
@RequestMapping(value = "/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CategorizeService categorizeService;
    @Autowired
    private UserBehaviorRecorder userBehaviorRecorder;

    /**
     * 根据指定类别、页面编码获取商品数据
     * */
    @RequestMapping(value = "/categorize")
    public String getCommodityByCategorize(PageDto pageQueryInfo, HttpServletRequest request){
        Integer nowPage = pageQueryInfo.getNowPage();
        Integer categorizeId = pageQueryInfo.getCategorizeId();
        if (nowPage == null){
            nowPage = 1;
        }
        if (categorizeId == null){
            categorizeId = 1;
        }
        int pageSize = EmallConf.COMMODITY_CATEGORIZE_PAGE_SIZE;

        //使用pagehelper插件实现分页查询
        PageHelper.startPage(nowPage, pageSize);
        List<Commodity> commodityList = commodityService.listCommodityByCategorize(categorizeId);

        //获取类名，用于在页面上展示
        Categorize categorize = categorizeService.getCategorizeInfoById(categorizeId);

        //类id有效且用户已登录的情况下记录行为日志
        //如果用户已登录，记录行为日志
        EmallUser loginInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        if (categorize != null && loginInfo != null){
            userBehaviorRecorder.putBrowserCategoryLog(loginInfo.getId(), categorizeId);
        }

        //页面展示信息
        PageDto commodityData = new PageDto();
        long total = ((Page)commodityList).getTotal();
        long pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        commodityData.setCategorizeId(categorizeId);
        commodityData.setNowPage(nowPage);
        commodityData.setTotal(total);
        commodityData.setPageCount(pageCount);
        commodityData.setData(commodityList);
        commodityData.setCategorizeName(commodityData.getCategorizeName());

        request.setAttribute(EmallConf.INDEX_COMMODITY_DATA_KEY, commodityData);
        return "products";
    }

    /**
     * 展示指定商品的详情页面
     * */
    @RequestMapping(value = "/details/{id}")
    public String showCommodityDtails(@PathVariable(value = "id") Integer id, HttpServletRequest request){
        Commodity distCommodity = commodityService.getCommodityById(id);
        if (distCommodity == null){
            return "error";
        }

        //如果用户已登录，记录行为日志
        EmallUser loginInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        if (loginInfo != null){
            userBehaviorRecorder.putClickItemLog(loginInfo.getId(), id);
        }

        request.setAttribute(EmallConf.INDEX_COMMODITY_DATA_KEY, distCommodity);
        return "single";
    }

    /**
     * 获取指定名称的图片
     * @param imgName 图片名
     * */
    @RequestMapping(value = "/img/{path}")
    public void getImages(HttpServletResponse response, @PathVariable(value = "path") String imgName){
        if (StringUtils.isEmpty(imgName)){
            return;
        }

        String imgPath = EmallConf.PRODUCT_IMG_PATH + imgName + ".jpg";
        File img = new File(imgPath);
        if (!img.exists()){
            return;
        }

        try {
            //读取图片数据到内存
            InputStream ins = new FileInputStream(img);
            int readNum = ins.available();
            byte[] imgData = new byte[readNum];
            ins.read(imgData);
            ins.close();

            //响应给客户端
            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            out.write(imgData);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据关键词搜索商品
     * */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchItemByKeyWord(PageDto pagequeryInfo, HttpServletRequest request){
        String keyWord = pagequeryInfo.getKeyword();
        Integer nowPage = pagequeryInfo.getNowPage();

        //verify
        if (StringUtils.isEmpty(keyWord)){
            return "redirect: index";
        }
        nowPage = nowPage == null ? 1 : nowPage;

        int pageSize = EmallConf.COMMODITY_SEARCH_PAGE_SIZE;

        //使用pagehelper插件实现分页查询
        PageHelper.startPage(nowPage, pageSize);
        List<Commodity> commodityList = commodityService.searchCommodity(keyWord);

        //如果用户已登录，记录行为日志
        EmallUser loginInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        if (loginInfo != null){
            userBehaviorRecorder.putSearchKeywordLog(loginInfo.getId(), keyWord);
        }

        //页面展示信息
        PageDto commodityData = new PageDto();
        long total = ((Page)commodityList).getTotal();
        long pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        commodityData.setNowPage(nowPage);
        commodityData.setTotal(total);
        commodityData.setPageCount(pageCount);
        commodityData.setData(commodityList);
        commodityData.setKeyword(keyWord);

        request.setAttribute(EmallConf.INDEX_COMMODITY_DATA_KEY, commodityData);
        request.setAttribute(EmallConf.SEARCH_SYMBOL, "yes");
        return "search";
    }
}
