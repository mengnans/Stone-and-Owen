package com.sao.pojo;

import java.util.Date;

public class Book {
    private Integer id;

    private Long bookprice;

    private String bookname;

    private String bookimg;

    private String bookauthor;

    private String bookbrief;

    private Date bookdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBookprice() {
        return bookprice;
    }

    public void setBookprice(Long bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg == null ? null : bookimg.trim();
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public String getBookbrief() {
        return bookbrief;
    }

    public void setBookbrief(String bookbrief) {
        this.bookbrief = bookbrief == null ? null : bookbrief.trim();
    }

    public Date getBookdate() {
        return bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }
}