package com.stan.library;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by uu on 2017/9/29.
 */

public abstract class AbstractDialogFragment extends DialogFragment{
    public static final String TAG = "AbstractDialogFragment";
    /**
     * width/height 宽、高 单位dp
     */
    private int width = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int height = ViewGroup.LayoutParams.WRAP_CONTENT;

    /**
     * fWidth/fHeight 百分比宽高
     */
    private float fWidth,fHeight;

    /**
     * style 动画 id
     */
    private int animationId;

    /**
     * FEATURE_NO_TITLE
     */
    private boolean noTitle;

    /**
     * 根view
     */
    protected View rootView;
    /**
     * cancel、confirm 点击事件监听
     */
    protected View.OnClickListener cancelListener,confirmListener;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("width",width);
        outState.putInt("height",height);
        outState.putFloat("fWidth",fWidth);
        outState.putFloat("fHeight",fHeight);
        outState.putInt("animationId",animationId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getSaveState(savedInstanceState);
        initWindow();
        rootView = inflater.inflate(setLayoutId(),container);
        initView(rootView);
        return rootView;
    }

    private void getSaveState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.width = savedInstanceState.getInt("width");
            this.height = savedInstanceState.getInt("height");
            this.fWidth = savedInstanceState.getFloat("fWidth");
            this.fHeight = savedInstanceState.getFloat("fHeight");
            this.animationId = savedInstanceState.getInt("animationId");
        }
    }

    /**
     * 初始化 Windows
     */
    private void initWindow() {
        if (noTitle)
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().getWindow().setWindowAnimations(animationId);//进出动画
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                startAnimation(rootView);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        resizeDialog();
    }

    /**
     * 比例 或 定长显示dialog 界面
     */
    private void resizeDialog() {
        if (getDialog() != null) {
            int relW = (fWidth>0 && fWidth <1)?(int)(getScreenWidthAndHeight()[0]* fWidth) :(width == -1 || width==-2)?width: (int)(width * density());
            int relH = (fHeight>0 && fHeight <1)?(int)(getScreenWidthAndHeight()[1]* fHeight) :(height==-1 || height==-2)?height: (int)(height * density());
            getDialog().getWindow().setLayout(relW,relH);
        }
    }

    /**
     * @return 屏幕尺寸
     */
    private int[] getScreenWidthAndHeight() {
        int size[] = new int[2];
        size[0] = getDialog().getContext().getResources().getDisplayMetrics().widthPixels;
        size[1] = getDialog().getContext().getResources().getDisplayMetrics().heightPixels;
        return size;
    }

    /**
     * @return 获取点密度
     */
    private float density() {
        return getDialog().getContext().getResources().getDisplayMetrics().density;
    }

    /**
     * @return  必须返回 根view id.
     */
    protected abstract int setLayoutId();

    /**
     * @param v 对View进行处理，比如设置事件，初始化等
     */
    protected abstract void initView(View v);

    /**
     * @param cancelTitle  Window.FEATURE_NO_TITLE 默认false
     * @return
     */
    public AbstractDialogFragment noTitle(boolean cancelTitle){
        this.noTitle = cancelTitle;
        return this;
    }


    /**
     * @param w dialog 窗口宽度 如果 0<w<1 则屏幕比例显示窗口宽度 单位 dp
     * @param h dialog 窗口高度 如果 0<h<1 则屏幕比例显示窗口高度 单位 dp
     *          w/h = -1 equals match_parent.
     *          w/h = -2 equals wrap_content.
     * @return 返回当前实例
     */
    public AbstractDialogFragment setSize(int w,int h){
        this.width = w;
        this.height = h;
        return this;
    }
    public AbstractDialogFragment setSize(float w,float h){
        this.fWidth = w;
        this.fHeight = h;
        return this;
    }
    public AbstractDialogFragment setSize(int w,float h){
        this.width = w;
        this.fHeight = h;
        return this;
    }
    public AbstractDialogFragment setSize(float w,int h){
        this.fWidth = w;
        this.height = h;
        return this;
    }


    /**
     * @param style style中定义的 进入/退出动画
     * @return current instance
     */
    public AbstractDialogFragment setStyleAnimation(int style){
        this.animationId = style;
        return this;
    }

    /**
     * @param manager FragmentManager 默认tag为当前类简名
     */
    public void show(FragmentManager manager) {
        show(manager,this.getClass().getSimpleName());
    }

    /**
     * @param view rootView dialog根View，用于对其进行动画,
     *               animator.start();应当在子类该方法中调用
     */
    protected void startAnimation(View view) {

    }


    /**
     * @param cancelListener 取消事件
     */
    public AbstractDialogFragment setCancelListener(View.OnClickListener cancelListener) {
        this.cancelListener = cancelListener;
        return this;
    }

    /**
     * @param confirmListener 选择事件
     */
    public AbstractDialogFragment setConfirmListener(View.OnClickListener confirmListener) {
        this.confirmListener = confirmListener;
        return this;
    }

    /**
     * @param cancelable 是否可以取消
     */
    public AbstractDialogFragment isCancelable(boolean cancelable) {
        setCancelable(cancelable);
        return this;
    }
}
