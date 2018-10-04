package com.mdm.lucidtimer

//import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import com.mdm.lucidtimer.R
import com.mdm.lucidtimer.ui.ringer.RingerFragment

class RingerActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ringer_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RingerFragment.newInstance())
                    .commitNow()
        }

        // Wake up phone if needed - https://stackoverflow.com/a/31996206/1762493
        if (intent.hasExtra(TimerExpiredReceiver().WAKE) && intent.extras!!.getBoolean(TimerExpiredReceiver().WAKE)) {
            this.window.setFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }
    }

}
