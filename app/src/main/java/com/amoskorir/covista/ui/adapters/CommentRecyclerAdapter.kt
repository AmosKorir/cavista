package com.amoskorir.covista.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amoskorir.covista.R
import com.amoskorir.domain.models.Comment
import kotlinx.android.synthetic.main.comments_item_layout.view.*


class CommentRecyclerAdapter(private val context: Context, private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentRecyclerAdapter.CommentRecyclerAdapterViewHolder>() {

    class CommentRecyclerAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentRecyclerAdapterViewHolder {
        return CommentRecyclerAdapterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.comments_item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: CommentRecyclerAdapterViewHolder, position: Int) {
        with(holder.itemView) {
            commentTv.text = comments[position].comment
        }
    }
}