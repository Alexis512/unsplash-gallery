package gallery.unsplash.alex.com.di

import android.app.Application
import dagger.Component
import gallery.unsplash.alex.com.presentation.ui.MainActivity
import javax.inject.Singleton

/**
 * Created by alex on 12.04.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, PresenterModule::class))
interface AppComponent {

    fun inject(app: Application)
    fun inject(mainActivity: MainActivity)
}