package com.reactions.deathlines.presentation.ui.features.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.reactions.deathlines.presentation.databinding.FragmentHomeBinding
import com.reactions.deathlines.presentation.ui.base.BaseFragment
import javax.inject.Inject

class PickGoalDeathlineFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var  binding : FragmentHomeBinding

    private val viewModel: GoalsViewModel by lazy {
        ViewModelProviders.of(this.activity!!, viewModelFactory).get(GoalsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun navigateTo(v: View) {
        //v.findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToAddGoalsActivity())
    }

    companion object {
        fun newInstance(): PickGoalDeathlineFragment = PickGoalDeathlineFragment()
    }
}