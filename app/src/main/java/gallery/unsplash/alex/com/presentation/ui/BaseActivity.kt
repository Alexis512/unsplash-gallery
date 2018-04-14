package gallery.unsplash.alex.com.presentation.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import gallery.unsplash.alex.com.presentation.mvp.BaseMvpPresenter
import gallery.unsplash.alex.com.presentation.mvp.presenters.BaseMvpView
import javax.inject.Inject

/**
 * Created by alex on 13.04.2018.
 */
abstract class BaseActivity<V : BaseMvpView, P : BaseMvpPresenter<V>> : AppCompatActivity(), BaseMvpView {

    @Inject
    protected lateinit var mvpPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpPresenter.attachView(this as V)


    }

    override fun onDestroy() {
        mvpPresenter.detachView()
        super.onDestroy()
    }
}