package me.free.example.sticky;

import me.free.example.sticky.sticky.StickyUtil;

public class ItemData {

    //列表内容
    public String name;

    //列表item的类型
    private int type;

    private ItemData(int type) {
        this.type = type;
    }

    //获取默认item数据
    public static ItemData getDefault() {
        return new ItemData(StickyUtil.NO_STICKY);
    }

    //获取需要吸附item数据
    public static ItemData getSticky() {
        return new ItemData(StickyUtil.STICKY);
    }

    public int getType(){
        return type;
    }

    //是否需要吸附效果
    public boolean isSticky() {
        return type == StickyUtil.STICKY;
    }

}
