package gallery.unsplash.alex.com.domain

import com.kc.unsplash.Unsplash
import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.SearchResults
import gallery.unsplash.alex.com.presentation.mvp.presenters.PresenterListener
import javax.inject.Inject

/**
 * Created by alex on 13.04.2018.
 */
class LoaderPhotoInteractor @Inject constructor() {

    private val USER_ID = "17348ba049fd702f42f9106a00c8745ea9bd4f1464c74862d371e01b91892c61"
    private var listener: PresenterListener? = null

    fun loadPhoto(query: String) {

        var client = Unsplash(USER_ID)
        client.searchPhotos(query, 1, 100, object : Unsplash.OnSearchCompleteListener {
            override fun onComplete(results: SearchResults?) {
                listener?.onSuccessLoadPhoto(results?.results as ArrayList<Photo>)
            }

            override fun onError(error: String?) {
                listener?.onFailureLoadPhoto()
            }
        })
    }


    fun setListener(presenter: PresenterListener) {
        listener = presenter
    }
}