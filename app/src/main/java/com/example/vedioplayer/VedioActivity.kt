package com.example.vedioplayer

import android.app.Activity
import android.media.session.MediaController
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_vedio.*
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat.startActivityForResult





class VedioActivity : AppCompatActivity()
{
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vedio)
        val intent = intent
        val callby=intent.getStringExtra("data")
        val mediaController = android.widget.MediaController(this)
        mediaController.setAnchorView(Vedioview)
        Vedioview.let {
            it.setMediaController(mediaController)
        }
        if(callby=="byraw"){
            Vedioview.setVideoPath("android.resource://" + packageName + "/" + R.raw.media)

            Vedioview.start()
        }
        else{
//            val videoPickIntent = Intent(Intent.ACTION_PICK)
//            videoPickIntent.type = "video/*"
//            startActivityForResult(
//                Intent.createChooser(videoPickIntent, "Please pick a video"),
//                1
//            )
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            intent.type = "*/*"
            val myintent = Intent.createChooser(intent, "select video")
            startActivityForResult(myintent, 1)

        }




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if(requestCode==1)
            {
                    if (resultCode== Activity.RESULT_OK){
                        val uri =data?.data
                        Vedioview.setVideoURI(uri)
                        Vedioview.start()

                    }
            }


    }


    override fun onStop() {
        Vedioview.pause()
        super.onStop()

    }

}