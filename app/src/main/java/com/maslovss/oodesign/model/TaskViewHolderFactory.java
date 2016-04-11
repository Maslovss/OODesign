package com.maslovss.oodesign.model;

import com.maslovss.oodesign.interfaces.IViewHolder;
import com.maslovss.oodesign.interfaces.IViewHolderFactory;

/**
 * Created by Сергей on 11.04.2016.
 */
public class TaskViewHolderFactory implements IViewHolderFactory<Task> {


    @Override
    public IViewHolder<Task> createViewHolder() {
        return new TaskViewHolder();
    }
}
