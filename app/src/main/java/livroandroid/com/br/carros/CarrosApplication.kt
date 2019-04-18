package livroandroid.com.br.carros

import android.app.Application
import android.util.Log
import java.lang.IllegalStateException

class CarrosApplication : Application() {

    private val TAG = "CarrosApplication"

    companion object {
        private var appInstance: CarrosApplication? = null

        fun getInstance(): CarrosApplication {
            if(appInstance == null){
                throw IllegalStateException("Configure a classe CarrosApplication no Manifest!")
            }
            return appInstance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarrosApplication.onTerminate()")
    }
}