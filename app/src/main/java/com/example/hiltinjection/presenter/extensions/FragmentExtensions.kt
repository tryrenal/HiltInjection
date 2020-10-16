package com.example.hiltinjection.presenter.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T : Any> Fragment.observe(liveData: LiveData<T>, block: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
        block(it)
    })
}