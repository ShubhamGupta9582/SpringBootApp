package com.demo.pkg.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OffsetLimitRequest implements Pageable {

    private Integer limit;
    private Integer offset;

    public OffsetLimitRequest() {
    }

    public OffsetLimitRequest(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public int getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
