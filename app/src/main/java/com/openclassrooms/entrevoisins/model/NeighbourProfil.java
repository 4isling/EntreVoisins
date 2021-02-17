package com.openclassrooms.entrevoisins.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.FavNeighbourEvent;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;


public class NeighbourProfil extends AppCompatActivity {
    private NeighbourApiService mApiService;
    private Neighbour neighbour;

    @BindView(R.id.avatar_neighbour)
    ImageView avatar;

    @BindView(R.id.profileName )
    TextView namePic;

    @BindView(R.id.textContactName)
    TextView nameContact;

    @BindView(R.id.textContactLocation)
    TextView location;

    @BindView(R.id.textUserPhone)
    TextView phoneNumber;

    @BindView(R.id.textUserURL)
    TextView url;

    @BindView(R.id.aboutMeText)
    TextView aboutMeText;

    @BindView(R.id.favBtn)
    FloatingActionButton favBtnStar;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        neighbour = (Neighbour) getIntent().getSerializableExtra("neighbourProfile");
        setContentView(R.layout.activity_neighbour_profil_page);
        ButterKnife.bind(this);
        onCreateToolbar();

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);

        initView();
        favBtnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new FavNeighbourEvent(neighbour));
                neighbour.setFav(!neighbour.isFav());
                initStarView();
            }
        });
    }

    private void initStarView()
    {
        favBtnStar.setImageResource(neighbour.isFav()?R.drawable.ic_star_white_24dp:R.drawable.ic_star_border_white_24dp);
    }

    private void initAvatar()  {
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(avatar);

    }
    private void initView() {
        namePic.setText(neighbour.getName());
        nameContact.setText(neighbour.getName());
        location.setText(neighbour.getAddress());
        phoneNumber.setText(neighbour.getPhoneNumber());
        url.setText(neighbour.getName() + ".skyrock.com");
        aboutMeText.setText(neighbour.getAboutMe());
        initAvatar();
        initStarView();
    }
    private void onCreateToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}


/*
getIntent
getExtra

 */