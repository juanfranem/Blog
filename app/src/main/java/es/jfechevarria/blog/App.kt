package es.jfechevarria.blog

import android.app.Application
import com.facebook.stetho.Stetho
import es.jfechevarria.blog.dii.viewModelModule
import es.jfechevarria.data.infrastructure.useCaseModule
import es.jfechevarria.data.local.dii.localModule
import es.jfechevarria.data.remote.dii.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
        initializeStetho()
    }

    private fun initializeStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(localModule, remoteModule, viewModelModule, useCaseModule)
        }
    }
}