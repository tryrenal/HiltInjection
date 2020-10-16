package com.example.hiltinjection.presenter.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

fun ImageView.urlImage(url: String) = Glide.with(this).load(GlideUrl(url)).into(this)