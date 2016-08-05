package edu.feicui.recyclerdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by admin on 2016/8/5.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ItemBean> mDatas;

    public RecyclerAdapter(Context context, ArrayList<ItemBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    /**
     * 创建View holder
     * 1. 需要找到自定义的 item.xml
     * 2. inflate
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);

        // 实例化 自己的Viewholder
        return new MyViewHolder(view);
    }

    /**
     * 给Item传参数
     * getView的事儿
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ItemBean itemBean = mDatas.get(position);
        Picasso.with(mContext)
                .load(itemBean.img)
                .into(holder.mCardImage);
        holder.mCardText.setText(itemBean.text);

        holder.mCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra("key",itemBean);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //public CardView  mCardView;
        public ImageView mCardImage;
        public TextView  mCardText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCardText = (TextView) itemView.findViewById(R.id.card_text);
            //mCardView = (CardView) itemView.findViewById(R.id.card_view);
            mCardImage = (ImageView) itemView.findViewById(R.id.card_image);
        }
    }

}
