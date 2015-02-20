package com.foxlee.jili.customcardview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Created by Ji Li
 */
public class MyView extends FrameLayout {
    public MyView(Context context, int layout) {
        super(context);
        InitView(layout);

    }

    private void InitView(int layout) {
        //  View view = inflate(getContext(), R.layout.test, null) ;
        View view = inflate(getContext(),layout,null) ;
        addView(view);
    }
}


