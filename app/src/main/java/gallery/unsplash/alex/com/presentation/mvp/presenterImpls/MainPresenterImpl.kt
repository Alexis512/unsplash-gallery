package gallery.unsplash.alex.com.presentation.mvp.presenterImpls

import com.kc.unsplash.models.Photo
import gallery.unsplash.alex.com.domain.LoaderPhotoInteractor
import gallery.unsplash.alex.com.presentation.mvp.presenters.MainPresenter
import gallery.unsplash.alex.com.presentation.mvp.presenters.PresenterListener
import gallery.unsplash.alex.com.presentation.mvp.views.MainView
import javax.inject.Inject

/**
 * Created by alex on 13.04.2018.
 */
class MainPresenterImpl @Inject constructor(private val loaderPhoto: LoaderPhotoInteractor) : BaseMvpPresenterImpl<MainView>(), MainPresenter, PresenterListener {

    init {
        loaderPhoto.setListener(this)
    }

    override fun onLoadPhoto(query: String) {
        loaderPhoto.loadPhoto(query)
    }

    override fun onSuccessLoadPhoto(image: ArrayList<Photo>) {
        mView?.onSuccessLoad(image)
    }

    override fun onFailureLoadPhoto() {
        mView?.onFailureLoad()
    }

}