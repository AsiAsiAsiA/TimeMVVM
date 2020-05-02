package com.example.timemvvm

import android.os.Handler
import androidx.lifecycle.LiveData

class TimeLiveData private constructor() : LiveData<String>() {

    private var secondsCount: Int = 0

    private val runnable = Runnable {
        addSeconds()
        Handler().postDelayed(runnable, 100)
    }

    //todo TimerTask http://developer.alexanderklimov.ru/android/java/timer.php
    private val timerTask =

    private val handler = Handler().postDelayed(runnable, 100)

    private object HOLDER {
        val instance = TimeLiveData()
    }

    companion object {
        val instance: TimeLiveData by lazy { HOLDER.instance }
    }

    fun start() = runnable.run()

    private fun addSeconds() {
        ++secondsCount
        value = getSecondsString()
    }

    fun pause() {
        //todo остановить Handler

    }

    fun stop() {
        //todo остановить и сбросить

        secondsCount = 0
        value = getSecondsString()
    }

    private fun getSecondsString(): String = secondsCount.toString()



}
