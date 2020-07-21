package com.example.news.ui.lenta

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.lenta_view_holder.view.*


class LentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(newsEntity: NewsEntity) {
        val uri: Uri =
            Uri.parse("https://e7.pngegg.com/pngimages/595/1016/png-clipart-cats-and-the-internet-lolcat-rage-comic-pet-cat-animals-cat-like-mammal.png")
        val draweeView = itemView.my_image_view
        draweeView.setImageURI(uri)

    }
}