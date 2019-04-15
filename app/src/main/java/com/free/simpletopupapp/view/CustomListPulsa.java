package com.free.simpletopupapp.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.free.simpletopupapp.R;

import java.text.DecimalFormat;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Jonathan on 14/04/2019
 */
public class CustomListPulsa  extends ArrayAdapter<String>{

    private final Activity context;
    private final Integer[] nominal;
    private final Integer[] harga;

    public CustomListPulsa(Activity context,
                          Integer[] nominal, Integer[] harga) {
        super(context, R.layout.list_pulsa);
        this.context = context;
        this.nominal = nominal;
        this.harga = harga;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_pulsa, null, true);


        DecimalFormat df = new DecimalFormat("#.###");

        TextView txtnominal = (TextView) rowView.findViewById(R.id.txtnominal);
        txtnominal.setText(df.format(nominal[position]));

        Button btn_buy = (Button) rowView.findViewById(R.id.btn_buy);
        btn_buy.setText("Rp "+df.format(harga[position]));

        return rowView;



    }


    @Override
    public int getCount(){
        return nominal.length;
    }
}