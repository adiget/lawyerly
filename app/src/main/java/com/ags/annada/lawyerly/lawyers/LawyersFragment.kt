package com.ags.annada.lawyerly.lawyers

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ags.annada.lawyerly.EventObserver
import com.ags.annada.lawyerly.R
import com.ags.annada.lawyerly.databinding.FragmentLawyersBinding
import com.ags.annada.lawyerly.home.MainFragmentDirections

class LawyersFragment : Fragment() {
    private val viewModel by viewModels<LawyersViewModel>()
    private lateinit var viewDataBinding: FragmentLawyersBinding

    lateinit var listAdapter: LawyersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentLawyersBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        setHasOptionsMenu(true)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupAdapter()
        setupNavigation()
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel

        if (viewModel != null) {
            listAdapter = LawyersAdapter(viewModel)
            viewDataBinding.lawyersList.adapter = listAdapter
        }
    }

    private fun setupNavigation() {
        viewModel.openDetailsEvent.observe(viewLifecycleOwner, EventObserver {
            openLawyerDetails(it)
        })
    }

    private fun openLawyerDetails(lawyerId: Int) {
        val action = MainFragmentDirections.actionMainFragmentToLawyerDetailFragment(lawyerId)
        findNavController().navigate(action)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_sort_by -> {
                viewModel.sortByLawyers()
                true
            }
            R.id.menu_filter -> {
                viewModel.filterLawyers()
                true
            }
            else -> false
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.lawyers_fragment_menu, menu)
    }
}