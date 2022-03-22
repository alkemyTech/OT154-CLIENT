package com.melvin.ongandroid.data.remote.firebase

import android.content.Context
import com.google.firebase.analytics.ktx.logEvent

class FirebaseEvent {

    companion object{
        fun setLogEvent(context: Context, eventName:String){
            val mAnalytics = FirebaseAnalyticsObj.getInstance(context)
            mAnalytics.logEvent(eventName){ }
        }
    }
}