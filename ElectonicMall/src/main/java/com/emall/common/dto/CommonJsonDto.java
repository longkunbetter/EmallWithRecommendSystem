package com.emall.common.dto;

public class CommonJsonDto {
    private Integer returnCode;
    private String returnMessage;
    private Object data;

    public CommonJsonDto(){

    }

    public CommonJsonDto(Integer returnCode, String returnMessage, Object data) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.data = data;
    }

    public CommonJsonDto(int returnCode, String returnMessage){
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
