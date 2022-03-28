package com.melvin.ongandroid.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.melvin.ongandroid.presentation.splashactivity.SplashViewModel
import com.melvin.ongandroid.view.MainActivity
import com.melvin.ongandroid.view.activities.login.LoginActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    //Utilizamos Kotlin Coroutine Autor: Leandro Valderas
    val activityScope = CoroutineScope(Dispatchers.Main)
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // Hacemos que se detenga durante 5 segundos en esta activity - Autor: Leandro Valderas
        activityScope.launch {
            delay(5000)
            setObservers()
            finish()

        }
    }
    //Agregamos el Toast al una vez finalice el Splash - Autor: Leandro Valderas
    override fun finish() {
        activityScope.cancel()
        super.finish()
        Toast.makeText(this, "Timer has finish", Toast.LENGTH_LONG).show()
    }

    //navegamos a un activity de destino en base si hay un token de usuario almacenado
    //Martin Re
    private fun setObservers(){
        viewModel.userIsLogged.observe(this,{
            if (it == true){
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }else{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.setSharedPreferences(this)
    }
}
