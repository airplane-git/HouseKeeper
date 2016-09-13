package cn.feicui.com.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class LogoActivity extends Activity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        ImageView imageView = (ImageView) findViewById(R.id.iv_logo1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_logo);
        animation.setAnimationListener(animationListener);
        imageView.startAnimation(animation);

    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {


        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Intent intent = new Intent(LogoActivity.this,TelmsgActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
