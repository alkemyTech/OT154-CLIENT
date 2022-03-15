package com.melvin.ongandroid.data.remote.firebase

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics

object FirebaseAnalyticsObj {
    fun getInstance(context: Context): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(context)
    }
}