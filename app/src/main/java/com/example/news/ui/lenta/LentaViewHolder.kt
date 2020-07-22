package com.example.news.ui.lenta

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.lenta_view_holder.view.*


class LentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(newsEntity: NewsEntity) {
        val uri: Uri =
            Uri.parse(newsEntity.urlToImage)
        val draweeView = itemView.my_image_view
        draweeView.setImageURI(uri)
        itemView.txvTitle.text = newsEntity.title
        itemView.txvText.text = newsEntity.description
        itemView.txvData.text = newsEntity.publishedAt
        newsEntity.author?.let {
            itemView.txvName.text = "${newsEntity.name} - ${newsEntity.author}"
        }?: kotlin.run {
            itemView.txvName.text = newsEntity.name
        }
    }
}