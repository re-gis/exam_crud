package com.jusish.exam.dtos;

import com.jusish.exam.models.User;

public class CreateBookDto {
    private String title;
    private long user_id;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
