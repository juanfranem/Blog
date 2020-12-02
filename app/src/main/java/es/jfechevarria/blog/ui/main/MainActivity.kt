package es.jfechevarria.blog.ui.main

import es.jfechevarria.blog.components.BaseActivity
import es.jfechevarria.blog.databinding.ActivityMainBinding
import es.jfechevarria.blog.ui.detail.DetailActivity
import es.jfechevarria.blog.ui.main.adapter.MainAdapter
import es.jfechevarria.blog.ui.main.adapter.OnPostClicked
import es.jfechevarria.domain.post.Post
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModel()
    lateinit var mainAdapter: MainAdapter

    override fun inflate() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }


    override fun subscribe() {
        viewModel.data.observe(this, {
            mainAdapter.submitList(it)
        })

        viewModel.state.observe(this, {

        })
    }

    override fun initialize() {
        mainAdapter = MainAdapter(object: OnPostClicked {
            override fun OnClick(p: Post) {
                startActivity(DetailActivity.newIntent(this@MainActivity, p))
            }
        })
        binding.recycler.adapter = mainAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }
}