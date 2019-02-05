package me.free.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.free.example.sticky.DataListAdapter;
import me.free.example.sticky.ItemData;
import me.free.example.sticky.sticky.StickyItemDecoration;

/**
 *  cpf
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new StickyItemDecoration());
        mRecyclerView.addItemDecoration(new ListDividerItemDecoration());
        mRecyclerView.setAdapter(new DataListAdapter(this, getDataList()));
    }

    private List<ItemData> getDataList() {
        List<ItemData> dataArrayList = new ArrayList<>();
        dataArrayList.add(getStickyItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getStickyItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getStickyItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getStickyItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getStickyItem());
        dataArrayList.add(getDefaultItem());
        dataArrayList.add(getDefaultItem());

        return dataArrayList;
    }

    private ItemData getDefaultItem(){
        ItemData itemData=ItemData.getDefault();
        itemData.name="A";
        return itemData;
    }

    private ItemData getStickyItem(){
        ItemData itemData=ItemData.getSticky();
        itemData.name="A";
        return itemData;
    }



}
