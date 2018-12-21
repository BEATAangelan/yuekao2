package ningjiaxin1.bwie.com.njx20181221.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class Pull extends LinearLayout {
    private int mMaxChilden;
    private int mLeft=20;
    private int mTop=20;
    public Pull(Context context) {
        super(context);
    }

    public Pull(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pull(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    //测量高度
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //找到最大的孩子
        int left=0;
        int top=0;
        findMaxChilden();
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!=0){
                if((left+view.getMeasuredWidth())>sizeWidth){
                    top+=mMaxChilden+mTop;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mLeft;
        }
        setMeasuredDimension(sizeWidth,(top+mMaxChilden)>sizeHeight?sizeHeight:top+mMaxChilden);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int left=0;
        int top=0;
        findMaxChilden();
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!=0){
                if((left+view.getMeasuredWidth())>getWidth()){
                    top+=mMaxChilden+mTop;
                    left=0;
                }
            }
            view.layout(left,top,view.getMeasuredWidth(),mMaxChilden+top);
            left+=view.getMeasuredWidth()+mLeft;
        }
    }
    private void findMaxChilden() {
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(view.getMeasuredHeight()>mMaxChilden){
                mMaxChilden=view.getMeasuredHeight();
            }
        }
    }
}
