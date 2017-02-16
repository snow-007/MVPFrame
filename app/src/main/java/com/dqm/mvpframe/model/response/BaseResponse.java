package com.dqm.mvpframe.model.response;

/**
 * Description:请求返回bean基类
 */
public class BaseResponse<T> {
    /** 请求是否成功返回 */
    public boolean success;
    /** 错误消息提示 */
    public String errorMsg;
    /** 查询结果所有记录条数 */
    public int recordsCount;
    /** 查询结果分页数 */
    public int pagesCount;
    public T datas;


}
