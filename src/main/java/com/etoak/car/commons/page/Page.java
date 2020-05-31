package com.etoak.car.commons.page;

import java.util.List;

public class Page<T> {
        private int pageNumber;
        private int pageSize;
    private int pageCount;
        private int total;
    private int pre;
    private int next;
    private int start;
        private List<T> rows;
    private boolean first;
    private boolean last;

    public boolean isFirst(){
        return (pageNumber==1);
    }

    public boolean isLast(){
        return (pageNumber==getPageCount());
    }

    public int getPageCount() {
        return (total+pageSize-1)/pageSize;
    }

    public int getPre() {
        if(pageNumber>1)
            return pageNumber-1;
        return 1;

    }

    public int getNext() {
        if(pageNumber<getPageCount())
            return pageNumber+1;
        return getPageCount();
    }

    public int getStart() {
        return (pageNumber-1)*pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
