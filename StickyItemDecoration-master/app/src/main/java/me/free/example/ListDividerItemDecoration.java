package me.free.example;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class ListDividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mDividerColor;

    private int mDividerHeight;

    private int mMarginLeft;

    private int mMarginRight;

    //是否绘制最后一行
    private boolean mIsDrawLastLine = false;

    private Paint mPaint;

    private int startPosition = 1;

    public ListDividerItemDecoration() {
        this(Color.parseColor("#3F51B5"), 1, 0, 0);
    }

    public ListDividerItemDecoration(int dividerColor, int dividerHeight, int marginLeft, int marginRight) {
      this(dividerColor, dividerHeight, marginLeft, marginRight, 1);
    }

    public ListDividerItemDecoration(int dividerColor, int dividerHeight, int marginLeft, int marginRight, int startPosition) {
        mDividerColor = dividerColor;
        mDividerHeight = dividerHeight;
        mMarginLeft = marginLeft;
        mMarginRight = marginRight;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mDividerColor);

        this.startPosition = startPosition;
    }

    public void drawLastLine(boolean isDrawLastLine) {
        mIsDrawLastLine = isDrawLastLine;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount() - (mIsDrawLastLine ? 0 : 1);

        for (int i = startPosition; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final int paddingLeft = child.getPaddingLeft();
            final int left = child.getLeft() + paddingLeft + getMarginLeft();
            final int right = child.getRight() - mMarginRight;
            final int top = child.getBottom();
            final int bottom = top + mDividerHeight;

            onDrawDivider(c, left, top, right, bottom, child);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, mDividerHeight);
    }

    private int getMarginLeft() {
        return mMarginLeft;
    }

    private void onDrawDivider(Canvas c, int left, int top, int right, int bottom, View child) {
        c.drawRect(left, top, right, bottom, mPaint);
    }
}
