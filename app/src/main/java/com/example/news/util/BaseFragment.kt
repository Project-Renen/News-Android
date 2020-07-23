package com.example.news.util

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.AppDatabase
import com.example.network.NetworkGate
import com.example.news.app.MainActivity
import com.example.news.viewmodel.NewsViewModel

open class BaseFragment : Fragment() {

    lateinit var networkGate: NetworkGate
    lateinit var newsViewModel: NewsViewModel
    lateinit var database: AppDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        networkGate = (activity as MainActivity).networkGate
        newsViewModel = (activity as MainActivity).newsViewModel
    }
}