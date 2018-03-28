package com.emall.common.controller;

import com.emall.common.constant.EmallConf;
import com.emall.common.service.CommodityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
