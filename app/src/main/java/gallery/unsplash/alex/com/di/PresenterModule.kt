package gallery.unsplash.alex.com.di

import dagger.Module
import dagger.Provides
import gallery.unsplash.alex.com.presentation.mvp.presenterImpls.MainPresenterImpl
import gallery.unsplash.alex.com.presentation.mvp.presenters.MainPresenter
import javax.inject.Singleton

/**
 * Created by alex on 13.04.2018.
 */
@Module
class PresenterModule {

    @Singleton
    @Provides
    fun providesMainPresenter(mainPresenterImpl: MainPresenterImpl): MainPresenter = mainPresenterImpl
}