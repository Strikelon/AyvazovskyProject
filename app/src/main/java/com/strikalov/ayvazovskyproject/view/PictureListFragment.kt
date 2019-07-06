package com.strikalov.ayvazovskyproject.view


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strikalov.ayvazovskyproject.R
import com.strikalov.ayvazovskyproject.databinding.FragmentPictureListBinding
import com.strikalov.ayvazovskyproject.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class PictureListFragment : Fragment() {

    val mainViewModel: MainViewModel by sharedViewModel()
    lateinit var binding: FragmentPictureListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel.onCreateListFragment()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picture_list, container, false)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        binding.recyclerView.layoutManager = GridLayoutManager(context,2)

        val itemsAdapter = ItemsAdapter()
        itemsAdapter.setViewModel(mainViewModel)
        binding.recyclerView.adapter = itemsAdapter

        return binding.root
    }


}
