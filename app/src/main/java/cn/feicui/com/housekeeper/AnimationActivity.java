package cn.feicui.com.housekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.feicui.com.housekeeper.fragment.ObjectAnimatorFragment;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class AnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animtor);

        //fragment第一种写法
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        FragmentTransaction transaction=fragmentManager.beginTransaction();
//        cn.feicui.com.housekeeper.ObjectAnimatorFragment fragment = new ObjectAnimatorFragment();
//        transaction.add(R.id.fl,fragment);
//        transaction.commit();

        //fragment简写
        getSupportFragmentManager().beginTransaction().
                add(R.id.fl, new ObjectAnimatorFragment()).commit();
    }
}
