package com.example.android.itour;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.itour.Adapter.CommentRecyclerViewAdapter;
import com.example.android.itour.Adapter.HorizontalRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContainerOpenActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_id)
    Toolbar toolbar;
    @BindView(R.id.place_text)
    TextView place_text;
    @BindView(R.id.top_place_image)
    ImageView top_place_image;
    @BindView(R.id.comment_recyclerview_id)
    RecyclerView comment_recyclerview;
    @BindView(R.id.play_button)
    Button play_button;

    MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_open);
        ButterKnife.bind(this);

        //Setting Up Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        Intent intent = getIntent();
        String Places = intent.getStringExtra("Title");
        int ImageView = intent.getIntExtra("ImageView", 0);

        place_text.setText(Places);
        top_place_image.setImageResource(ImageView);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mortal_kombat_theme_song_original);
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        //ArrayAdapter for the Horizontal RecyclerView
        List<Tour> travel2 = new ArrayList<>();
        travel2.add(new Tour("Travel There", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel OutSide", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel InThere", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel Vacation", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel Nigeria", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel There", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel OutSide", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel InThere", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel Vacation", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));
        travel2.add(new Tour("Travel Nigeria", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been."));

        CommentRecyclerViewAdapter commentRecyclerViewAdapter = new CommentRecyclerViewAdapter(this, travel2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        comment_recyclerview.setLayoutManager(layoutManager);
        comment_recyclerview.setAdapter(commentRecyclerViewAdapter);
    }

    //Inflating the menu to toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Setting up a Click Listener for the Toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }
}
