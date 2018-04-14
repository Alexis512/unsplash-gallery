package gallery.unsplash.alex.com.presentation.ui.recyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kc.unsplash.models.Photo
import gallery.unsplash.alex.com.R

/**
 * Created by alex on 14.04.2018.
 */
class ImageRecyclerViewAdapter(private var items: ArrayList<Photo>,
                               private val sizeDisplay: Int,
                               private val listener : (Photo) -> Unit) : RecyclerView.Adapter<ImageRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ImageRecyclerViewHolder(LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.item_image, parent, false))

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ImageRecyclerViewHolder?, position: Int) = holder?.bind(items[position], sizeDisplay, listener)!!
}