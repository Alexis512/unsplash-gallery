package gallery.unsplash.alex.com

import android.app.Application
import gallery.unsplash.alex.com.di.AppComponent
import gallery.unsplash.alex.com.di.AppModule
import gallery.unsplash.alex.com.di.DaggerAppComponent

/**
 * Created by alex on 13.04.2018.
 */
class App : Application() {

    companion object {
        lateinit var component : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        component.inject(this)

    }
}