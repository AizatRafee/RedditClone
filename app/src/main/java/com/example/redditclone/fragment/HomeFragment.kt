package com.example.redditclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redditclone.R
import com.example.redditclone.adapter.TopicsAdapter
import com.example.redditclone.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by aizat
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val topics = viewModel.getTopics()
        val topicsAdapter = TopicsAdapter(topics)

        rv_topics.layoutManager = LinearLayoutManager(requireContext())
        rv_topics.adapter = topicsAdapter

    }

}