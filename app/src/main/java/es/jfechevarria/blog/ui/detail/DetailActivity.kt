package es.jfechevarria.blog.ui.detail

import android.content.Context
import android.content.Intent
import es.jfechevarria.blog.components.BaseActivity
import es.jfechevarria.blog.databinding.ActivityDetailBinding
import es.jfechevarria.blog.ui.detail.adapter.CommentsAdapter
import es.jfechevarria.domain.post.Post
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity: BaseActivity<ActivityDetailBinding>() {

    private val viewModel: DetailViewModel by viewModel()
    lateinit var commentAdapter: CommentsAdapter

    companion object {
        private const val POST_EXTRA = "post_extra"

        fun newIntent(c: Context, p: Post): Intent = Intent(c, DetailActivity::class.java).apply {
            putExtra(POST_EXTRA, p)
        }
    }

    override fun inflate() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun subscribe() {
        viewModel.comments.observe(this, {
            commentAdapter.submitList(it)
        })
        viewModel.user.observe(this, {
            binding.user.text = it.name
        })
        viewModel.state.observe(this, {

        })
    }

    override fun initialize() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        commentAdapter = CommentsAdapter()
        binding.comments.adapter = commentAdapter
        val post = intent.extras?.getParcelable<Post>(POST_EXTRA)
        binding.title.text = post?.title
        binding.body.text = post?.body
    }

    override fun onResume() {
        super.onResume()
        intent.extras?.getParcelable<Post>(POST_EXTRA)?.let {
            viewModel.load(it)
        } ?: kotlin.run {
            finish()
        }
    }

}