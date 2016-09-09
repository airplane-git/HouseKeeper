package cn.feicui.com.housekeeper.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.feicui.com.housekeeper.R;


public class ObjectAnimatorFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_animator_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_logo3);

        Animator animator = AnimatorInflater.loadAnimator(getContext(),R.animator.anim_logo);
        animator.setTarget(imageView);
        animator.start();
        return view;
    }
}
