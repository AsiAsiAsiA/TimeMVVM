package com.example.timemvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeLiveData = TimeLiveData.instance
        timeLiveData.observe(this, Observer { tvTime.text = it  })

        btnStart.setOnClickListener { timeLiveData.start() }
        btnPause.setOnClickListener { timeLiveData.pause() }
        btnStop.setOnClickListener { timeLiveData.stop() }

    }
}
