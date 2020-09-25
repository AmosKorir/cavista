package com.amoskorir.covista.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.amoskorir.covista.R
import com.amoskorir.covista.ui.activities.ImageViewActivity
import com.amoskorir.domain.CovistaConstants
import com.amoskorir.domain.models.Image
import com.bumptech.glide.Glide


class ImageAdapter(private val mContext: Context, private val images: List<Image>) :
    ArrayAdapter<Image>(mContext, 0) {

    override fun getCount(): Int {
        return images.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        }
        val imageView = view!!.findViewById(R.id.imageLy) as ImageView

        Glide.with(context)
            .load(images[position].link)
            .placeholder(R.drawable.placeholder)
            .into(imageView)
        imageView.setOnClickListener {
            context.startActivity(
                Intent(context, ImageViewActivity::class.java).putExtra(
                    CovistaConstants.IMAGE,
                    images[position]
                )
            )
        }
        return view
    }

}