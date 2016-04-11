package com.maslovss.oodesign;

import android.view.View;
import android.widget.TextView;

import com.maslovss.oodesign.interfaces.IViewHolder;

/**
 * Created by Сергей on 23.03.2016.
 */
public class StringViewHolder implements IViewHolder<String> {

    TextView textView=null;


    @Override
    public void bind(View parentview, int... res) {
        if (res.length != 1)
            throw new IllegalArgumentException("Array res[] should have 1 element.");
        textView = (TextView) parentview.findViewById(res[0]);
    }

    @Override
    public void show(String element) {
        if (textView != null )
            textView.setText( (String) element );
    }
}
