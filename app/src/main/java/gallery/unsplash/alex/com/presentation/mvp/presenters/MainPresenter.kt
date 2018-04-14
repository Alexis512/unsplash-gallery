package gallery.unsplash.alex.com.presentation.mvp.presenters

import gallery.unsplash.alex.com.presentation.mvp.BaseMvpPresenter
import gallery.unsplash.alex.com.presentation.mvp.views.MainView

/**
 * Created by alex on 13.04.2018.
 */
interface MainPresenter : BaseMvpPresenter<MainView> {

    fun onLoadPhoto(query: String)
}