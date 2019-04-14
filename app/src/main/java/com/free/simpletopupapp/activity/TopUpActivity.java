package com.free.simpletopupapp.activity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.free.simpletopupapp.R;
import com.free.simpletopupapp.adapter.TabAdapter;
import com.free.simpletopupapp.fragment.PulsaFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopUpActivity extends BaseActivity   {
    private TabAdapter adapter;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        ButterKnife.bind(this);

        //untuk custom action bar
        setActionBarTitleCenter(getApplicationContext().getResources().getString(R.string.top_up));

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new PulsaFragment(),
                getApplicationContext().getResources().getString(R.string.title_pulsa));
        adapter.addFragment(new PulsaFragment(),
                getApplicationContext().getResources().getString(R.string.title_data_pck));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }


    @Override
    public void onBackPressed() {exitYN();}

    public void exitYN(){
        AlertDialog.Builder ad=new AlertDialog.Builder(TopUpActivity.this);
        ad.setTitle(getApplicationContext().getResources().getString(R.string.app_name));
        ad.setMessage(getApplicationContext().getResources().getString(R.string.sure_to_quit));
        ad.setPositiveButton(getApplicationContext().getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }});
        ad.setNegativeButton(getApplicationContext().getResources().getString(R.string.no),
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1) {
                    }});
        ad.show();
    }

}
