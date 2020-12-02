package es.jfechevarria.blog.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<View: ViewBinding>: AppCompatActivity() {

    lateinit var binding: View

    abstract fun inflate()
    abstract fun subscribe()
    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflate()
        setContentView(binding.root)
        subscribe()
        initialize();
    }

}