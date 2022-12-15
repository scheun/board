package com.my.board.model;

public class PageParam {

    private int page = 1;
    private int amount = 10;
    private int start = 0;

    public PageParam() {
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.start = (page-1)*amount;
    }

    public void setPage(int page) {
        this.page = page;
        this.start = (page-1)*amount;
    }

    public int getPage() {
        return page;
    }

    public int getAmount() {
        return amount;
    }

    public int getStart() {
        return start;
    }
}
