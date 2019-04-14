package com.free.simpletopupapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.free.simpletopupapp.R;
import com.free.simpletopupapp.SimpleTopUpApp;
import com.free.simpletopupapp.utils.PromoModel;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<PromoModel> imageModelArrayList;
    private Context context;
    public PromoAdapter(Context ctx, ArrayList<PromoModel> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        context=ctx;
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public PromoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(PromoAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());

    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.iv);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;
            LinearLayout.LayoutParams paramsRcView =
                    new LinearLayout.LayoutParams((width*4)/5,height/7);
            iv.setLayoutParams(paramsRcView);


        }

    }
}
