package com.maslovss.oodesign.model;

import android.view.View;
import android.widget.TextView;

import com.maslovss.oodesign.interfaces.IViewHolder;

import java.security.InvalidParameterException;

/**
 * Created by Сергей on 28.03.2016.
 */
public class EventViewHolder implements IViewHolder<Event> {

    TextView tv_title;
    TextView tv_message;

    @Override
    public void bind(View parentview, int... res) {
        if (res.length !=2 )
            throw new InvalidParameterException("EventViewHolder bind should have 2 resource ids");
        tv_title =  (TextView) parentview.findViewById(res[0]);
        tv_message =  (TextView) parentview.findViewById(res[1]);
    }

    @Override
    public void show(Event element) {
        if (tv_title != null)
            tv_title.setText(element.title);

        if (tv_message != null)
            tv_message.setText(element.message);
    }
}
