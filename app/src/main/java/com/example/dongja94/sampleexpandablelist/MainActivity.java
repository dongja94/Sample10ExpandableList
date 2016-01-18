package com.example.dongja94.sampleexpandablelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ExpandableListView listView;

    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ExpandableListView)findViewById(R.id.expandableListView);

        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
//                listView.expandGroup(groupPosition);
            }
        });

        initData();

        for (int i = 0; i < mAdapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }

    }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int childCount = 2 + r.nextInt(4);
            for (int j = 0; j < childCount; j++) {
                mAdapter.put("group"+i, "group"+i+":child"+j);
            }
        }
    }
}
