package com.hdevelopers.converter.controllers.request;

import com.hdevelopers.converter.model.Info;
import com.hdevelopers.converter.model.Query;

import java.io.Serializable;

public class QueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;
    private String result;
    private String success;
    private Info info;
    private Query query;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
