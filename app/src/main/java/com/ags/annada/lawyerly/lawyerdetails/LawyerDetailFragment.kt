package com.ags.annada.lawyerly.lawyerdetails

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ags.annada.lawyerly.home.HomeScreenActivity
import com.ags.annada.lawyerly.R
import com.ags.annada.lawyerly.databinding.FragmentLawyerDetailBinding
import kotlinx.android.synthetic.main.fragment_lawyer_detail.*

class LawyerDetailFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentLawyerDetailBinding

    private val args: LawyerDetailFragmentArgs by navArgs()

    private val viewModel by viewModels<LawyerDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lawyer_detail, container, false)
        viewDataBinding = FragmentLawyerDetailBinding.bind(view).apply {
            viewmodel = viewModel
        }

        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.setLawyerId(args.lawyerId)

        setHasOptionsMenu(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as HomeScreenActivity).supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.back)
            setDisplayHomeAsUpEnabled(true)
        }

        val animDrawable = scheduler_btn.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()
    }
}