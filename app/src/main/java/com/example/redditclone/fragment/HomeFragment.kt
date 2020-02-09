package com.example.redditclone.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redditclone.R
import com.example.redditclone.adapter.TopicsAdapter
import com.example.redditclone.viewmodel.HomeViewModel
import com.example.redditclone.viewmodel.HomeViewModel.Companion.TOPIC_ID
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by aizat
 */
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as? AppCompatActivity)?.supportActionBar?.title =
            getString(R.string.popular_topic)

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val topics = viewModel.getTopics()
        val topicsAdapter = TopicsAdapter(topics.value)

        rv_topics.layoutManager = LinearLayoutManager(requireContext())
        rv_topics.adapter = topicsAdapter

        topics.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                tv_empty.visibility = View.VISIBLE
            } else {
                tv_empty.visibility = View.GONE
            }
            topicsAdapter.topic = it
            topicsAdapter.notifyDataSetChanged()
        })

        topicsAdapter.upVoteEvent.observe(viewLifecycleOwner, Observer {
            viewModel.upVote(it)
        })

        topicsAdapter.downVoteEvent.observe(viewLifecycleOwner, Observer {
            viewModel.downVote(it)
        })

        topicsAdapter.clickEvent.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle().apply {
                putInt(TOPIC_ID, it)
            }
            findNavController().navigate(R.id.action_homeFragment_to_singlePostFragment, bundle)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_post ->
                findNavController().navigate(R.id.action_homeFragment_to_postFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}