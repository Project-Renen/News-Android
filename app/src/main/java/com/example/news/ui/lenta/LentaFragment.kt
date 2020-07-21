package com.example.news.ui.lenta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import kotlinx.android.synthetic.main.fragment_lenta.*

class LentaFragment : Fragment() {
    val adapter = LentaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    fun setupAdapter() {
        rvNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvNews.adapter = adapter
        val list = ArrayList<NewsEntity>()
        list.add(
            NewsEntity(
                0, "Cat",
                "https://e7.pngegg.com/pngimages/595/1016/png-clipart-cats-and-the-internet-lolcat-rage-comic-pet-cat-animals-cat-like-mammal.png",
                "Кошки вери бьютифул"
            )
        )
        adapter.setList(list)

    }
}