package com.melvin.ongandroid.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.appToolbar.toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navFragmentHome, R.id.navFragmentAboutUs, R.id.navFragmentActivities,
            R.id.navFragmentNews, R.id.navFragmentReviews, R.id.navFragmentDonate,
            R.id.navFragmentContactUs,R.id.navFragmentTestimonials), binding.dlSideBar)

        setupActionBarWithNavController(findNavController(R.id.navHostFragment),
            appBarConfiguration)
        binding.navView.setupWithNavController(findNavController(R.id.navHostFragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}