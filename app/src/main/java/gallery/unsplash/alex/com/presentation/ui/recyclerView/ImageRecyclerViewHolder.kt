package gallery.unsplash.alex.com.presentation.ui.recyclerView

import android.support.v7.widget.RecyclerView
import android.view.View
import com.kc.unsplash.models.Photo
import com.squareup.picasso.Picasso
import gallery.unsplash.alex.com.R
import kotlinx.android.synthetic.main.item_image.view.*

class ImageRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Photo, size: Int, lisneter: (Photo) -> Unit) {
        setSizeImage(size)
        Picasso.with(itemView.context)
                .load(item.urls.regular)
                .placeholder(R.drawable.ic_photo)
                .fit()
                .centerCrop()
                .into(itemView.imagePhoto)
        itemView.imagePhoto.setOnClickListener({ lisneter(item) })
    }

    private fun setSizeImage(size: Int) {
        var params = itemView.imagePhoto.layoutParams
        params.width = size / 2 - 2
        params.height = size / 2 - 2
        itemView.imagePhoto.layoutParams = params
    }

}
