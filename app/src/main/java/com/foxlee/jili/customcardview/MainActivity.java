package com.foxlee.jili.customcardview;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * An {@link Activity} showing a tuggable "Hello World!" card.
 * <p/>
 * The main content view is composed of a one-card {@link CardScrollView} that provides tugging
 * feedback to the user when swipe gestures are detected.
 * If your Glassware intends to intercept swipe gestures, you should set the content view directly
 * and use a {@link com.google.android.glass.touchpad.GestureDetector}.
 *
 * @see <a href="https://developers.google.com/glass/develop/gdk/touch">GDK Developer Guide</a>
 */
public class MainActivity extends Activity {

    /**
     * {@link CardScrollView} to use as the main content view.
     */
    private CardScrollView mCardScroller;

    private MyView mView1,mView2;


    private ArrayList<View> arrayList;

    private Context context;
    private MyAdapter myAdapter ;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        //init custom view
        mView1 = new MyView(this,R.layout.firstlayout);
//        mView2 = new MySecondView(this);
        mView2 = new MyView(this,R.layout.secondlayout);



        //add views to arraylist
        arrayList = new ArrayList<View>();
        arrayList.add(mView1);
        arrayList.add(mView2);

        //set my custom adapter
        myAdapter = new MyAdapter(arrayList);
        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(myAdapter);
        mCardScroller.activate();
        // Handle the TAP event.
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Plays disallowed sound to indicate that TAP actions are not supported.
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.DISALLOWED);
            }
        });
        setContentView(mCardScroller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }



}
