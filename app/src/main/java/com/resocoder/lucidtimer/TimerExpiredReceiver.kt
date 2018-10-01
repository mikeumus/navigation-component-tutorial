package com.mdm.lucidtimer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mdm.lucidtimer.util.NotificationUtil
import com.mdm.lucidtimer.util.PrefUtil
//import android.support.v4.content.ContextCompat.startActivity


class TimerExpiredReceiver : BroadcastReceiver() {
    val WAKE: String = "Wake up" // https://discuss.kotlinlang.org/t/unresolved-reference-another-kotlin-class/3115/2?u=mikeumus

    override fun onReceive(context: Context, intent: Intent) {
        NotificationUtil.showTimerExpired(context)

        PrefUtil.setTimerState(MainActivity.TimerState.Stopped, context)
        PrefUtil.setAlarmSetTime(0, context)

        val myAct = Intent(context, PhotosFragment::class.java)
        myAct.putExtra(WAKE, true)
        myAct.flags = Intent.FLAG_FROM_BACKGROUND
        context.startActivity(myAct)
    }
}
