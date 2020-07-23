package com.example.news.ui.lenta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.database.entity.News
import com.example.news.R

class LentaAdapter() : RecyclerView.Adapter<LentaViewHolder>() {
    val list = ArrayList<NewsEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LentaViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.lenta_view_holder, parent, false)
        return LentaViewHolder(v)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: LentaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setList(newList: List<NewsEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()

    }

    fun setNewsList(newList: List<News>) {
        val list = arrayListOf<NewsEntity>()
        for (x in newList) {
            list.add(
                NewsEntity(
                    x.title ?: "",
                    x.url ?: "",
                    x.description ?: "",
                    x.author ?: "",
                    x.publishedAt ?: "",
                    x.name ?: "",
                    x.urlToImage ?: ""
                )
            )
        }
        setList(list)

    }
}