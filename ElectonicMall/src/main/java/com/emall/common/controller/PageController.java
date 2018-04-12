package com.emall.common.controller;

import com.emall.common.constant.EmallConf;
import com.emall.common.dto.TopCategorizeDto;
import com.emall.common.entity.CartItem;
import com.emall.common.entity.Categorize;
import com.emall.common.entity.Commodity;
import com.emall.common.entity.EmallUser;
import com.emall.common.dto.IndexDataDto;
import com.emall.common.service.CartService;
import com.emall.common.service.CategorizeService;
import com.emall.common.service.CommodityService;
import com.emall.recomd.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class PageController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private RecommendService recommendService;
    @Autowired
    private CategorizeService categorizeService;
    @Autowired
    private CartService cartService;

    /**
     * 为用户准备主页
     * */
    @RequestMapping(value = "index")
    public String generateUserIndex(HttpServletRequest request){
        //主菜单信息生成,先从application缓存中找，若没有从数据库找并放入缓存
        ServletContext application = request.getServletContext();
        List<TopCategorizeDto> meunData =
                (List<TopCategorizeDto>) application.getAttribute(EmallConf.INDEX_MEUN_DATA_KEY);
        if (meunData == null){
            meunData = this.generateMeunData();
            application.setAttribute(EmallConf.INDEX_MEUN_DATA_KEY, meunData);
        }

        /**
         * 准备首页商品数据
         * */
        IndexDataDto indexCommoditys;
        //判断用户是否登录，若未登录则主页商品随机展示，不使用推荐，否则使用推荐
        EmallUser user = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        if (user == null){
            indexCommoditys = commodityRandomDisplay();
        }
        else {
            String uid = String.valueOf(user.getId());
            indexCommoditys = commodityDisplayWithRecommendSystem(uid);
        }
        request.setAttribute(EmallConf.INDEX_COMMODITY_DATA_KEY, indexCommoditys);

        return "index";
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
                this.categorizeService.listTopCategorize(EmallConf.TOP_CATEGORIZES_NUM);
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
                    this.categorizeService.listCategorizeByTopCategorize(categorize.getId());
            topCategorizeDto.setSubCategorizes(subCategorizeList);

            meunDto.add(topCategorizeDto);
        }

        return meunDto;
    }

    /**
     * 用户未登录的情况下，随机展示商品
     * @return
     *      用于展示到主页的商品
     * */
    private IndexDataDto commodityRandomDisplay(){
        int selectAmount = EmallConf.INDEX_GUESS_YOU_LIKE_DISPLAY_NUM +
                EmallConf.INDEX_FEATURED_DISPLAY_NUM +
                EmallConf.INDEX_PANNEL_DISPLAY_NUM;
        List<String> randomCommodityIds = commodityService.commodityRandomSelect(selectAmount);
        List<Commodity> commodities = commodityService.getCommodityDataByIds(randomCommodityIds);

        return splitCommoditys(commodities);
    }

    /**
     * 用户已登录的情况下，通过推荐接口展示为用户定制的商品
     * @param uid
     *          用户id
     * @return
     *          用于展示到主页的商品
     * */
    private IndexDataDto commodityDisplayWithRecommendSystem(String uid){
        int recommendAmount = EmallConf.INDEX_GUESS_YOU_LIKE_DISPLAY_NUM +
                EmallConf.INDEX_FEATURED_DISPLAY_NUM +
                EmallConf.INDEX_PANNEL_DISPLAY_NUM;
        List<String> commoditiesId = recommendService.recommendItemsForUser(uid, recommendAmount);
        List<Commodity> commodities = commodityService.getCommodityDataByIds(commoditiesId);

        return splitCommoditys(commodities);
    }

    private IndexDataDto splitCommoditys(List<Commodity> commodityList){
        int offset = 0;
        //pannel 数据
        List<Commodity> pannelData = commodityList.subList(offset, offset+EmallConf.INDEX_PANNEL_DISPLAY_NUM);
        offset += pannelData.size();
        //guess you like 数据
        List<Commodity> guessData = commodityList.subList(offset, offset+EmallConf.INDEX_GUESS_YOU_LIKE_DISPLAY_NUM);
        offset += guessData.size();
        //feature 数据
        List<Commodity> featureData = commodityList.subList(offset, offset+EmallConf.INDEX_FEATURED_DISPLAY_NUM);

        return new IndexDataDto(pannelData, guessData, featureData);
    }
}
