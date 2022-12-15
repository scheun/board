package com.my.board.model;

import lombok.Getter;

@Getter
public class PageDTO {
    private int endPage;
    private int startPage;
    private int realEnd;
    private int total;

    boolean prev, next;

    PageParam pageParam;

    public PageDTO(PageParam pageParam, int total) {

        this.pageParam = pageParam;
        this.total = total;

        int current = pageParam.getPage();
        int amount = pageParam.getAmount();

        this.endPage = (int)( Math.ceil(current*0.1))*10;

        this.startPage = endPage-9;

        this.realEnd = (int)Math.ceil(total/amount);

        if(realEnd < endPage) {
            this.endPage = realEnd;
        }

        this.prev = current > 1;
        this.next = current < realEnd;
    }
}
