package gallery.unsplash.alex.com.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by alex on 12.04.2018.
 */

@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun providesApp() = app

    @Singleton
    @Provides
    fun providesContext(): Context = app
}