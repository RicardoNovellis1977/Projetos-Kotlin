package com.ricardo.youtubeapp.activity

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.ricardo.youtubeapp.R
import com.ricardo.youtubeapp.data.helper.YouTubeConfig
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val youtubePlayerView : YouTubePlayerView = playerVideo
        youtubePlayerView.initialize(YouTubeConfig().CHAVE_YOUTUBE_API,this)
    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {


        val bundle : Bundle? = intent.extras
        val idVideo : String? = bundle?.getString("idVideo")

        p1?.setFullscreen(true)
        p1?.setShowFullscreenButton(false)
        p1?.loadVideo(idVideo)
    }
    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
    }
}
