package com.example.news.util

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.network.NetworkGate
import com.example.news.app.MainActivity

open class BaseFragment:Fragment() {

    lateinit var networkGate: NetworkGate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       networkGate= (activity as MainActivity).networkGate
    }
}