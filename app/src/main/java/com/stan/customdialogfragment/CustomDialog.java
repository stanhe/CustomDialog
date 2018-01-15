package com.stan.customdialogfragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import com.stan.library.AbstractDialogFragment;


/**
 * Created by uu on 2017/9/29.
 */

public class CustomDialog extends AbstractDialogFragment implements View.OnClickListener {

    @Override
    public int setLayoutId() {
        attachToRoot = true; // default is false;
        return R.layout.dialog_custom;
    }

    @Override
    protected void initDataBeforeViewCreated() {

    }

    @Override
    public void initView(View v) {
        v.findViewById(R.id.cancel).setOnClickListener(this);
        v.findViewById(R.id.ok).setOnClickListener(this);
    }

    /**
     * @param v 自定义dialog的动画效果
     */
    @Override
    protected void startAnimation(View v) {
        int mDuration = 500;
        v.setPivotX(v.getWidth()/2);
        v.setPivotY(v.getHeight()/2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(v, "rotationY", 90,88,88,45,0).setDuration(mDuration),
                ObjectAnimator.ofFloat(v, "alpha", 0,0.4f,0.8f, 1).setDuration(mDuration*3/2),
                ObjectAnimator.ofFloat(v, "scaleX", 0,0.5f, 0.9f, 0.9f, 1).setDuration(mDuration),
                ObjectAnimator.ofFloat(v,"scaleY",0,0.5f, 0.9f, 0.9f, 1).setDuration(mDuration)

        );
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                dismiss();
                break;
            case R.id.ok:
                if (confirmListener != null) {
                    confirmListener.onClick(view);
                }
                break;
        }
    }
}
