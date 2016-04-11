package com.maslovss.oodesign.model;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.maslovss.oodesign.interfaces.IViewHolder;

import java.security.InvalidParameterException;

/**
 * Created by Сергей on 11.04.2016.
 */
public class TaskViewHolderNoCheck implements IViewHolder<Task> {

    TextView tvTitle;
    TextView tvWorker;


    @Override
    public void bind(View parentview, int... res) {
        if (res.length != 2)
            throw new InvalidParameterException("TaskViewHolder bind should call with 3 resource ids.");

        tvTitle = (TextView) parentview.findViewById(res[0]);
        tvWorker = (TextView) parentview.findViewById(res[1]);
    }

    @Override
    public void show(Task element) {
        tvTitle.setText(element.title);
        tvWorker.setText(element.worker);
    }
}
