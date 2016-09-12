package cn.feicui.com.main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import cn.feicui.com.main.R;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class ViewAnimFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_anim_view,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.iv_logo2);

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anim);
        imageView.startAnimation(animation);
        animation.start();
        return view;
    }
}
