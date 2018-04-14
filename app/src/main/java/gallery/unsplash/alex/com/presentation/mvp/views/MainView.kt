package gallery.unsplash.alex.com.presentation.mvp.views

import com.kc.unsplash.models.Photo
import gallery.unsplash.alex.com.presentation.mvp.presenters.BaseMvpView

/**
 * Created by alex on 13.04.2018.
 */
interface MainView : BaseMvpView {

    fun onSuccessLoad(image: ArrayList<Photo>)
    fun onFailureLoad()
}