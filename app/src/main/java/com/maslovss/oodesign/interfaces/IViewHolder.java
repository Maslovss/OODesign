package com.maslovss.oodesign.interfaces;

import android.view.View;

/**
 * Created by Сергей on 23.03.2016.
 */
public interface IViewHolder<T> {

    /** Bind internal views to resources
     *  @param parentview View which contains elements
     *  @param res  Resources ids
     */
    public void bind(View parentview , int... res);


    public void show(T element );
}
