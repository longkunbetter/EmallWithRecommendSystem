package com.emall.common.dto;

import java.util.List;

public class PageDto {
    /**
     * 分页公共属性
     * */
    private Integer nowPage;
    private Long total;
    private List<?> data;
    private Long pageCount;

    /**
     * 商品类别id，用作分类查询时的查询参数
     * */
    private Integer categorizeId;
    /**
     * 商品类别名称，用于分类查询时的返回
     * */
    private String categorizeName;

    public String getCategorizeName() {
        return categorizeName;
    }

    public void setCategorizeName(String categorizeName) {
        this.categorizeName = categorizeName;
    }

    public Integer getCategorizeId() {
        return categorizeId;
    }

    public void setCategorizeId(Integer categorizeId) {
        this.categorizeId = categorizeId;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }
}
