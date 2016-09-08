package cn.feicui.com.housekeeper;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img_logo=(ImageView) findViewById(R.id.iv_logo);
        AnimatorSet animator= (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.anim_logo);
        animator.setTarget(img_logo);
        animator.start();
    }
}
