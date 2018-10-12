package com.ntub.closer.a180923.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ntub.closer.a180923.*;
//import com.ntub.closer.a180923.data.Life;
import com.ntub.closer.a180923.data.*;
//import com.ntub.closer.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataViewHolder>{
    //----------------
    // 連接資料
    //----------------
    ArrayList<Life> lives;


    public static class DataViewHolder extends RecyclerView.ViewHolder {
        //----------------------------
        // 連結資料的顯示物件宣告
        //----------------------------
        CardView cardView;
        TextView info_TextView;        //資料文字
        ImageView picture_ImageView;   //資料圖片
        int position;                  //資料序號

        DataViewHolder(View itemView) {
            super(itemView);

            //----------------------------
            // 連結資料的顯示物件取得
            //----------------------------
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            info_TextView = (TextView)itemView.findViewById(R.id.info_text);
            picture_ImageView = (ImageView)itemView.findViewById(R.id.imageView);

            //--------------------
            // 當卡片被點擊時
            //--------------------
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context=view.getContext();

                    // 產生一個Bundle, 內存CardView的序號
                    Bundle bundle=new Bundle();
                    bundle.putInt("position", position);

                    // 產生一個Intent, 用來轉換Activity
                    Intent intent=new Intent();

                    // 將Bundle物件 加入 Intent物件中
                    intent.putExtras(bundle);

                    // 設定轉換的Activity
                    intent.setClass(context, Main2Activity.class);

                    // 轉換至下一個Activity
                    context.startActivity(intent);
                }
            });
        }
    }

    //------------------
    // 將連結的資料
    //------------------
    public MyAdapter(ArrayList<Life> lives){
        this.lives = lives;
    }

    @Override
    public int getItemCount() {
        return lives.size();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //------------------------------------------
        // 顯示資料物件來自 R.layout.mylayout 中
        //------------------------------------------
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mylayout, viewGroup, false);
        DataViewHolder dataViewHolder = new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
        //---------------------------------
        // 顯示資料物件 及 資料項目 的對應
        //---------------------------------
        dataViewHolder.info_TextView.setText(lives.get(i).getInfo());
        dataViewHolder.picture_ImageView.setImageResource(lives.get(i).getPicture());
        dataViewHolder.position=i;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
