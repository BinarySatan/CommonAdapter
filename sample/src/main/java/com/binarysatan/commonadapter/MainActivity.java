package com.binarysatan.commonadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.binarysatan.library.adapter.MultiLayoutAdapter;
import com.binarysatan.library.adapter.holder.BaseHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private static List<String> mDatas = new ArrayList<>();

    static {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //普通 adapter.
//        mRecyclerView.setAdapter(new BaseAdapter<String>(this, R.layout.item_layout, mDatas) {
//            @Override
//            public void updateUI(BaseHolder holder, int position, String data) {
//                holder.setText(R.id.tv, data);
//            }
//        });

        //多布局adapter
        mRecyclerView.setAdapter(new MultiLayoutAdapter<String>(this, mDatas) {
            @Override
            public int multiLayout(int position) {
                // 这里根据 自己需求, 来决定返回什么布局
                if (position == 0 || position == 2 || position == 4)
                    return R.layout.item_layout;
                return R.layout.item_layout1;
            }

            @Override
            public void updateMuiltUI(BaseHolder holder, int position, List<String> data) {
                if (R.layout.item_layout == getItemViewType(position)) {
                    holder.setText(R.id.tv, "哈哈");
                } else {
                    holder.setText(R.id.tv, "嘎嘎");
                }
            }

            @Override
            public void setListener(final BaseHolder holder, final List<String> data) {
                holder.getView(R.id.tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, data.get(holder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
