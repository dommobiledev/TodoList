package com.example.dominik.todolist;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Dominik on 22/11/2017.
 */

public class Todo {
    private UUID mId;
    private String mTitle, mDetail;
    private Date mDate;
    private boolean mIsComplete;

    public Todo() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDetail() {
        return mDetail;
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isComplete() {
        return mIsComplete;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDetail(String detail) {
        mDetail = detail;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setComplete(boolean complete) {
        mIsComplete = complete;
    }
}
