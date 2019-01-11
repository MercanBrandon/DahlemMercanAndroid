package com.example.merca.dahlemmercan.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.merca.dahlemmercan.R
import com.example.merca.dahlemmercan.adapter.GitHubAdapter
import com.example.merca.dahlemmercan.api.GitHubInterface
import com.example.merca.dahlemmercan.api.RetrofitClient
import com.example.merca.dahlemmercan.models.Follower
import com.example.merca.dahlemmercan.models.ListFollower
import kotlinx.android.synthetic.main.fragment_followers.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Response

class FollowersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerFollower.layoutManager = LinearLayoutManager(context)

        val client = RetrofitClient().getClient().create(GitHubInterface::class.java)
        client.getAllFollowers().enqueue(object : retrofit2.Callback<ListFollower>{

            override fun onResponse(call: Call<ListFollower>, response: Response<ListFollower>) {
                if (response.isSuccessful){

                    val adapter = GitHubAdapter(response.body()!!.items)
                    recyclerFollower.adapter = adapter
                }
                else
                    context?.toast("" + response.code() + response.message())
            }

            override fun onFailure(call: Call<ListFollower>, t: Throwable) {
                context!!.toast("onFailure")
            }

        })
    }
}
