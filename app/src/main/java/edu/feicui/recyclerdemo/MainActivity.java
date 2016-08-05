package edu.feicui.recyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<ItemBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // 告诉Recyclerview 里面的item 应该以什么样的方式展现
        //CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.VERTICAL);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);

        mDatas = setDatas();
        RecyclerAdapter adapter = new RecyclerAdapter(this,mDatas);

        mRecyclerView.setAdapter(adapter);

    }

    public ArrayList<ItemBean> setDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                ItemBean bean = new ItemBean();
                bean.img = "http://ww1.sinaimg.cn/mw600/6200e46agw1f69h2p2i60j20ri0ic77h.jpg";
                bean.text = "飞机" + i;
                mDatas.add(bean);
            } else {
                ItemBean bean = new ItemBean();
                bean.img = "http://ww3.sinaimg.cn/mw600/6e5b2895gw1f6gaadswpxj20c80icwf1.jpg";
                bean.text = "beauty girl " + i;
                mDatas.add(bean);
            }
        }
        return mDatas;
    }
 }
