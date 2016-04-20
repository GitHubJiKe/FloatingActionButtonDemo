package com.ypf.floatingactionbuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnitemClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private FloatingActionButton button;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setAdapter();

    }

    /**
     * 设置Adapter及其他
     */
    private void setAdapter() {
        //这是控制RecyclerView的布局形式的管理器
        mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        adapter = new RecyclerViewAdapter(this);
        adapter.setOnitemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);//一定不要忘了这句，否则无内容显示
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        button = (FloatingActionButton) findViewById(R.id.floatingactionbutton);
        button.attachToRecyclerView(recyclerView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "floatingactionbutton", Toast.LENGTH_SHORT).show();
                button.hide();
            }
        });
    }

    @Override
    public void OnitemClick(View view, int position) {
        Toast.makeText(MainActivity.this, "OnitemClick position = " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnitemLongClick(View view, int position) {
        Toast.makeText(MainActivity.this, "OnitemLongClick position = " + position, Toast.LENGTH_SHORT).show();
    }
}
