package com.example.news.ui.lenta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.database.entity.News
import com.example.network.controller.news.MultipleNewsResponse
import com.example.network.controller.news.NewsResponse
import com.example.news.R
import com.example.news.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_lenta.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LentaFragment : BaseFragment() {
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

        networkGate.loadNews(object : Callback<MultipleNewsResponse> {
            override fun onFailure(call: Call<MultipleNewsResponse>, t: Throwable) {
                println(t)
            }

            override fun onResponse(
                call: Call<MultipleNewsResponse>,
                response: Response<MultipleNewsResponse>
            ) {
                println(response)

                val body = response.body()
                body?.let {
                    val list = arrayListOf<News>()
                    for (x in it.articles) {
                        val news =
                            News(
                                title = x.title ?: "",
                                url = x.url ?: "",
                                description = x.description ?: "",
                                author = x.author ?: "",
                                publishedAt = x.publishedAt ?: "",
                                name = x.source?.name ?: "",
                                urlToImage = x.urlToImage ?: ""
                            )

                        GlobalScope.launch {
                            newsViewModel.insertNews(news)
                        }
                    }

                }
            }
        })
        GlobalScope.launch {
            newsViewModel.allNews()
        }

        newsViewModel.allNews.observe(viewLifecycleOwner, object : Observer<List<News>> {
            override fun onChanged(t: List<News>?) {
                t?.let { list ->
                    activity?.runOnUiThread {
                        adapter.setNewsList(list)
                    }
                }

            }

        })
    }

    fun setupAdapter() {
        rvNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvNews.adapter = adapter
        val list = ArrayList<NewsEntity>()
//        list.add(
//            NewsEntity(
//                0, "Cat",
//                "https://e7.pngegg.com/pngimages/595/1016/png-clipart-cats-and-the-internet-lolcat-rage-comic-pet-cat-animals-cat-like-mammal.png",
//                "Кошки вери бьютифул", "Taita", "12.03.14", "News"
//            )
//        )
//
//        list.add(
//            NewsEntity(
//                1, "Kitty",
//                "https://w7.pngwing.com/pngs/975/863/png-transparent-birman-turkish-angora-sphynx-cat-kitten-ragdoll-ragdoll.png",
//                "Котята", "Taita", "12.03.14", "News"
//            )
//        )
//
//        list.add(
//            NewsEntity(
//                2, "Kitty cat",
//                "https://w7.pngwing.com/pngs/975/863/png-transparent-birman-turkish-angora-sphynx-cat-kitten-ragdoll-ragdoll.png",
//                "Котята - кошки", "Taita", "12.03.14", "News"
//            )
//        )
//
//        list.add(
//            NewsEntity(
//                3, "Kitty and cat",
//                "https://w7.pngwing.com/pngs/975/863/png-transparent-birman-turkish-angora-sphynx-cat-kitten-ragdoll-ragdoll.png",
//                "Котята и кошки", "Taita", "12.03.14", "News"
//            )
//        )
//
//        list.add(
//            NewsEntity(
//                4, "Pussy",
//                "https://w7.pngwing.com/pngs/975/863/png-transparent-birman-turkish-angora-sphynx-cat-kitten-ragdoll-ragdoll.png",
//                "Кицки", "Taita", "12.03.14", "News"
//            )
//        )
//
//        list.add(
//            NewsEntity(
//                5, "Pussy",
//                "https://e7.pngegg.com/pngimages/595/1016/png-clipart-cats-and-the-internet-lolcat-rage-comic-pet-cat-animals-cat-like-mammal.png",
//                "Кицки", "Taita", "12.03.14", "News"
//            )
//        )
//
//        list.add(
//            NewsEntity(
//                6, "Pussy",
//                "https://e7.pngegg.com/pngimages/595/1016/png-clipart-cats-and-the-internet-lolcat-rage-comic-pet-cat-animals-cat-like-mammal.png",
//                "Кицки", "Taita", "12.03.14", "News"
//            )
//        )
//        adapter.setList(list)

    }
}