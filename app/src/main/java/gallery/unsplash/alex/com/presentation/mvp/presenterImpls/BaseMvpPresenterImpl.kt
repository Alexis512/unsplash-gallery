package gallery.unsplash.alex.com.presentation.mvp.presenterImpls

import gallery.unsplash.alex.com.presentation.mvp.BaseMvpPresenter
import gallery.unsplash.alex.com.presentation.mvp.presenters.BaseMvpView

/**
 * Created by alex on 13.04.2018.
 */
abstract class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView: V? = null

    override fun attachView(mvpView: V) {
        mView = mvpView
    }

    override fun detachView() {
        mView = null
    }

}