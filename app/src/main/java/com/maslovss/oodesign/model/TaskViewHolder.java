package com.maslovss.oodesign.model;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.maslovss.oodesign.interfaces.IViewHolder;

import java.security.InvalidParameterException;

/**
 * Created by Сергей on 11.04.2016.
 */
public class TaskViewHolder implements IViewHolder<Task> {

    CheckBox checkboxDone;
    TextView tvTitle;
    TextView tvWorker;

    @Override
    public void bind(View parentview, int... res) {

        if (res.length != 3)
            throw new InvalidParameterException("TaskViewHolder bind should call with 3 resource ids.");

        checkboxDone = (CheckBox) parentview.findViewById(res[0]);
        tvTitle = (TextView) parentview.findViewById(res[1]);
        tvWorker = (TextView) parentview.findViewById(res[2]);
    }

    @Override
    public void show(Task element) {
        checkboxDone.setText("");
        checkboxDone.setChecked(element.isDone);
        tvTitle.setText(element.title);
        tvWorker.setText(element.worker);
    }
}
