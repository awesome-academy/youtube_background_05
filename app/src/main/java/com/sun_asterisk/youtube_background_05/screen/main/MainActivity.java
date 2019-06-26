package com.sun_asterisk.youtube_background_05.screen.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.sun_asterisk.youtube_background_05.R;
import com.sun_asterisk.youtube_background_05.screen.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView mImvLogo;
    private ImageView mImvNavLeft;
    private ImageView mImvNavRight;
    private ImageView mImvNavRight2;
    private EditText mEdtSearch;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigation();
        initView();
        initData();
    }

    private void initView() {
        homeNav();
        setNewPage(new HomeFragment());
    }

    private void initData() {

    }

    private void initNavigation() {
        mImvLogo = findViewById(R.id.image_logo_left);
        mImvNavLeft = findViewById(R.id.image_nav_left);
        mImvNavRight = findViewById(R.id.image_nav_right);
        mImvNavRight2 = findViewById(R.id.image_nav_right2);
        mEdtSearch = findViewById(R.id.edt_search_bar);
    }

    private void showNavigation(ImageView imageView, int resId, View.OnClickListener listener) {
        if (imageView != null) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(resId);
            if (listener != null) {
                imageView.setOnClickListener(listener);
            }
        }
    }

    private void hideNavigation(ImageView imageView) {
        if (imageView != null) {
            imageView.setVisibility(View.GONE);
        }
    }

    public void homeNav() {
        hideNavLeft();
        showLogo();
        hiddenNavRight2();
        hideSearchBar();
        showNavRight(R.drawable.ic_search, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchNav();
            }
        });
    }

    public void searchNav() {
        hideLogo();
        hiddenNavRight2();
        showSearchBar();
        showNavLeft(R.drawable.ic_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeNav();
                //                onBackPressed();
            }
        });
        showNavRight(R.drawable.ic_search, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Submit
            }
        });
    }

    public void showLogo() {
        mImvLogo.setVisibility(View.VISIBLE);
    }

    public void hideLogo() {
        mImvLogo.setVisibility(View.GONE);
    }

    public void hideNavRight() {
        hideNavigation(mImvNavRight);
    }

    public void showNavLeft(int resId, View.OnClickListener listener) {
        showNavigation(mImvNavLeft, resId, listener);
    }

    public void hideNavLeft() {
        hideNavigation(mImvNavLeft);
    }

    public void showNavRight(int resId, View.OnClickListener listener) {
        showNavigation(mImvNavRight, resId, listener);
    }

    public void hiddenNavRight() {
        mImvNavRight.setVisibility(View.GONE);
    }

    public void showNavRight2(int resId, View.OnClickListener listener) {
        showNavigation(mImvNavRight2, resId, listener);
    }

    public void hiddenNavRight2() {
        mImvNavRight2.setVisibility(View.GONE);
    }

    public void showSearchBar() {
        mEdtSearch.setVisibility(View.VISIBLE);
    }

    public void hideSearchBar() {
        mEdtSearch.setVisibility(View.GONE);
    }

    public void setNewPage(Fragment fragment) {
        try {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
                    getSupportFragmentManager().popBackStackImmediate();
                }
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_main, fragment, "currentFragment");
            transaction.commitAllowingStateLoss();
            if (mFragment != null) transaction.remove(mFragment);
            mFragment = fragment;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragment);
        transaction.setCustomAnimations(R.anim.trans_right_to_left_in, R.anim.trans_right_to_left_out,R.anim.trans_left_to_right_in, R.anim.trans_left_to_right_out);
        transaction.add(R.id.frame_main, fragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().popBackStackImmediate(R.id.frame_main,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, fragment).commit();
    }
}
