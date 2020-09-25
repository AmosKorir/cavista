package com.amoskorir.covista.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.Observer
import com.amoskorir.covista.R
import com.amoskorir.covista.ui.adapters.ImageAdapter
import com.amoskorir.domain.models.Image
import com.amoskorir.viewmodels.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    val searchViewModel: SearchViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        searchViewModel.imagesLiveData.observe(this, {
            Log.d("look",it.size.toString())
            showImages(it)
        })

        searchViewModel.handleErrorLiveData.observe(this, {
            handleError(it)
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searchString: String?): Boolean {
                searchViewModel.searchImages(searchString!!)
                return false
            }

            override fun onQueryTextChange(searchString: String?): Boolean {
                return false
            }
        })
    }

    private fun showImages(images: List<Image>) {
        val imageAdapter = ImageAdapter(this, images)
        imageGridView.adapter = imageAdapter
    }
}