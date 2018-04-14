package gallery.unsplash.alex.com.presentation.mvp.presenters

import com.kc.unsplash.models.Photo

/**
 * Created by alex on 14.04.2018.
 */
interface PresenterListener {

    fun onSuccessLoadPhoto(image: ArrayList<Photo>)
    fun onFailureLoadPhoto()
}