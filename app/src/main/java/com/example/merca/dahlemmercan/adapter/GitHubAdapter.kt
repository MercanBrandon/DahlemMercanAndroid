package com.example.merca.dahlemmercan.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.merca.dahlemmercan.R
import com.example.merca.dahlemmercan.models.Follower
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_follower.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import org.jetbrains.anko.toast

class GitHubAdapter(private val items: List<Follower>) : RecyclerView.Adapter<GitHubAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GitHubAdapter.ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.item_follower, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: GitHubAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(follower: Follower){
            itemView.followerLogin.text = follower.login
            itemView.followerTextViewUrl.text = follower.reposUrl

            Picasso.get().load(follower.avatarUrl).into(itemView.imageAvatar)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}