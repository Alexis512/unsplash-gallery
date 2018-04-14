package gallery.unsplash.alex.com.presentation.mvp

import gallery.unsplash.alex.com.presentation.mvp.presenters.BaseMvpView

/**
 * Created by alex on 13.04.2018.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(mvpView: V)
    fun detachView()
}