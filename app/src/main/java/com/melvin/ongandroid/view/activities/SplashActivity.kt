package com.melvin.ongandroid.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.melvin.ongandroid.view.activities.login.LoginActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    //Utilizamos Kotlin Coroutine Autor: Leandro Valderas
    val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // Hacemos que se detenga durante 5 segundos en esta activity - Autor: Leandro Valderas
        activityScope.launch {
            delay(5000)
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
    //Agregamos el Toast al una vez finalice el Splash - Autor: Leandro Valderas
    override fun finish() {
        activityScope.cancel()
        super.finish()
        Toast.makeText(this, "Timer has finish", Toast.LENGTH_LONG).show()
    }
}
