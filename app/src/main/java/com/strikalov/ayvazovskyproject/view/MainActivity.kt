package com.strikalov.ayvazovskyproject.view

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.strikalov.ayvazovskyproject.R
import com.strikalov.ayvazovskyproject.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MAIN_ACTIVITY_LOG"
    }

    val mainViewModel: MainViewModel by viewModel()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        mainViewModel.getPictureId().observe(this, Observer { id ->

            id?.let {
                val bundle = Bundle()
                bundle.putInt(PictureDetailFragment.ARG_ID, it)
                navController.navigate(R.id.pictureDetailFragment, bundle)
            }

        })

    }
}
