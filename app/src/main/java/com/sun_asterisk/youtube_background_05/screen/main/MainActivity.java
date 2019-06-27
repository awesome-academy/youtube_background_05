package com.sun_asterisk.youtube_background_05.screen.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.sun_asterisk.youtube_background_05.R;
import com.sun_asterisk.youtube_background_05.screen.home.HomeFragment;
import com.sun_asterisk.youtube_background_05.screen.search.SearchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment mFragment;
    private ImageView mImageIconSearch;
    private ImageView mImageIconBack;
    private ImageView mImageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mImageIconSearch = findViewById(R.id.imageIconSearch);
        mImageIconBack = findViewById(R.id.imageIconBack);
        mImageLogo = findViewById(R.id.imageLogo);
        mImageIconSearch.setOnClickListener(this);
        mImageIconBack.setOnClickListener(this);
        setNewPage(new HomeFragment());
    }

    private void initData() {

    }

    private void setNewPage(Fragment fragment) {
        try {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
                    getSupportFragmentManager().popBackStackImmediate();
                }
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameMain, fragment, fragment.getClass().getName());
            transaction.commitAllowingStateLoss();
            if (mFragment != null) transaction.remove(mFragment);
            mFragment = fragment;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragment);
        transaction.setCustomAnimations(R.anim.trans_right_to_left_in, R.anim.trans_right_to_left_out,R.anim.trans_left_to_right_in, R.anim.trans_left_to_right_out);
        transaction.add(R.id.frameMain, fragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageIconSearch:
                mImageIconSearch.setVisibility(View.GONE);
                mImageLogo.setVisibility(View.GONE);
                mImageIconBack.setVisibility(View.VISIBLE);
                addFragment(new SearchFragment());
                break;
            case R.id.imageIconBack:
                mImageIconBack.setVisibility(View.GONE);
                mImageLogo.setVisibility(View.VISIBLE);
                mImageIconSearch.setVisibility(View.VISIBLE);
                onBackPressed();
                break;
        }
    }
}
