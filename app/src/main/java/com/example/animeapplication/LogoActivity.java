package com.example.animeapplication;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class LogoActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    GestureDetector gd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        viewFlipper=findViewById(R.id.viewFlipper);
        gd=new GestureDetector(this,new MyGestureListener());
    }
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


            if(e2.getX()>e1.getX()){
                if(viewFlipper.getDisplayedChild()==0){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Intent intent=new Intent(LogoActivity.this,homeFragment.class);
                           // startActivity(intent);
                           //overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                        }
                    },10000);
                }
                Animation Itorin= AnimationUtils.loadAnimation(LogoActivity.this,R.anim.ltorin);
                viewFlipper.setInAnimation(Itorin);
                Animation Itorout= AnimationUtils.loadAnimation(LogoActivity.this,R.anim.ltorout);
                viewFlipper.setOutAnimation(Itorout);
                viewFlipper.showPrevious();
                return true;
            }
            else if(e2.getX()<e1.getX()){
                if(viewFlipper.getDisplayedChild()==0){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(LogoActivity.this,MainActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                        }
                    },10000);
                }
                Animation Itorin= AnimationUtils.loadAnimation(LogoActivity.this,R.anim.you);
                viewFlipper.setInAnimation(Itorin);
                Animation Itorout= AnimationUtils.loadAnimation(LogoActivity.this,R.anim.youout);
                viewFlipper.setOutAnimation(Itorout);
                viewFlipper.showNext();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


}
