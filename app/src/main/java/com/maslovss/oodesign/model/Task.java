package com.maslovss.oodesign.model;

/**
 * Created by Сергей on 11.04.2016.
 */
public class Task {
    boolean isDone = false;
    String  title;
    String  worker;

    public Task(boolean isDone , String title , String worker){
        this.isDone = isDone;
        this.title = title;
        this.worker = worker;
    }

    public Task( String title , String worker){
        this.isDone = false;
        this.title = title;
        this.worker = worker;
    }

    public Task( ){
        this.isDone = false;
        this.title = "";
        this.worker = "";
    }

}
