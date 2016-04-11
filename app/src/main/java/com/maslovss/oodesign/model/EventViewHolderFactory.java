package com.maslovss.oodesign.model;

import android.util.Log;

import com.maslovss.oodesign.interfaces.IViewHolder;
import com.maslovss.oodesign.interfaces.IViewHolderFactory;

/**
 * Created by Сергей on 28.03.2016.
 */
public class EventViewHolderFactory implements IViewHolderFactory<Event> {
    @Override
    public IViewHolder<Event> createViewHolder() {
        return new EventViewHolder();
    }
}
