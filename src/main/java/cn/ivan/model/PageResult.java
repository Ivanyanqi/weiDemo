package cn.ivan.model;

import java.util.List;

/**
 * 分页模型
 * User: 仙人球
 * Date: 2017/5/14
 * Time: 22:48
 */
public class PageResult<T> {

    private int currentPage; // 当前页

    private int pageSize;

    private int pages; // 总页数

    private int total; // 总条数

    private List<T> result ;

    public int getCurrentPage() {
        return currentPage == 0 ? 1 : currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize == 0 ? 10 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return this.total % pageSize == 0 ? total / pageSize : total/pageSize + 1;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
