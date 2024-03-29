package com.strikalov.ayvazovskyproject.view

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
        Picasso.get()
                .load(url)
                .into(imageView)
}