package com.foxlee.jili.customcardview;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;

public class MyAdapter extends CardScrollAdapter
{
    ArrayList<View> cardsList;
    public MyAdapter(ArrayList<View> cardsList)
    {
        this.cardsList = cardsList;
    }

    @Override
    public int getCount() {
        return cardsList.size();
    }

    @Override
    public Object getItem(int i) {
        return cardsList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return cardsList.get(i);
    }

    @Override
    public int getPosition(Object o) {
        return cardsList.indexOf(o);
    }

    @Override
    public int getViewTypeCount() {
        return CardBuilder.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position){
        return 0;//should be changed, it's just an example
    }
}