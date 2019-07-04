package com.strikalov.ayvazovskyproject.view


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikalov.ayvazovskyproject.R
import com.strikalov.ayvazovskyproject.databinding.FragmentPictureDetailBinding
import com.strikalov.ayvazovskyproject.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class PictureDetailFragment : Fragment() {

    companion object {
        const val ARG_ID: String = "ARG_ID"
        const val TAG = "PictureDetailTAG"
    }

    val mainViewModel: MainViewModel by sharedViewModel()
    lateinit var binding: FragmentPictureDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val pictureId = arguments?.getInt(ARG_ID)

        pictureId?.let {
            Log.i(TAG, it.toString())
            mainViewModel.onCreateDetailFragment(it)
        }

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picture_detail, container, false)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        return binding.root
    }


}
