package com.free.simpletopupapp.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.free.simpletopupapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PromoActivity extends BaseActivity {
    @Bind(R.id.img_promo)
    ImageView img_promo;
    @Bind(R.id.txt_promo)
    TextView txt_promo;
    @Bind(R.id.btn_copy)
    Button btn_copy;

    private int index=0;
    private String TAG=PromoActivity.class.getSimpleName();
    private int[] myImageList =
            new int[]{R.drawable.kredivo_xl,
                    R.drawable.kredivo_indosat,
                    R.drawable.kredivo_sepulsa,
                    R.drawable.kredivo_telkomsel};

    @OnClick(R.id.btn_copy)
    void btnCopyClick() {
        if(!TextUtils.isEmpty(txt_promo.getText().toString())){
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("clipPromo", txt_promo.getText().toString());
            clipboard.setPrimaryClip(clip);
            Log.d(TAG,"clipboard.getPrimaryClip().getItemAt(0): "+clipboard.getPrimaryClip().getItemAt(0));
            Toast.makeText(PromoActivity.this,
                    getApplicationContext().getResources().getString(R.string.text_copied), Toast.LENGTH_LONG).show();


        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        ButterKnife.bind(this);

        index = getIntent().getIntExtra("index",0);
        img_promo.setImageResource(myImageList[index]);

        txt_promo.setText(getApplicationContext().getResources().getString(R.string.promos)+"-"+(index+1));

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        LinearLayout.LayoutParams paramsRcView =
                new LinearLayout.LayoutParams(width,height/5);
        img_promo.setLayoutParams(paramsRcView);

        setActionBarTitleCenter(getApplicationContext().getResources().getString(R.string.title_merchat_promo));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //this is for back button
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
