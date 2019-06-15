package com.example.vedioplayer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(baseContext,VedioActivity::class.java)

        btnraw.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                intent.putExtra("data","byraw")
                startActivity(intent)
            }
        })
        btnfromphone.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(intent)
            }
        })
    }
}
