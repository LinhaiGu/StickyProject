package me.free.example.sticky.sticky;

import android.view.View;

public class StickyUtil {

    public static final int STICKY = 1;

    public static final int NO_STICKY = 0;

    public static boolean isStickyView(View view) {
        return (Boolean) view.getTag();
    }

    public static int getStickViewType() {
        return STICKY;
    }

    //是否需要吸附效果
    public static boolean isSticky(int itemType) {
        return itemType ==StickyUtil.STICKY;
    }
}
