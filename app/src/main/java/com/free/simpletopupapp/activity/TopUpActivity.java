package com.free.simpletopupapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.free.simpletopupapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopUpActivity extends BaseActivity {
    @Bind(R.id.navigation)
    BottomNavigationView navigation;
    private int saveState;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_pulsa);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_data_pck);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        ButterKnife.bind(this);
        //untuk custom action bar
        setActionBarTitleCenter(getApplicationContext().getResources().getString(R.string.title_pulsa));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
