package com.example.lovecalculator.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentLoveCalcBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveCalcFragment : Fragment() {

    private var _binding: FragmentLoveCalcBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoveCalcViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoveCalcBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initClickers() {
        with(binding) {
            btCalculate.setOnClickListener {
                viewModel.getLiveData(
                    edtFirstName.text.toString(), edtSecondName.text.toString()
                ).observe(this@LoveCalcFragment, Observer {
                    findNavController().navigate(
                        R.id.calcResultFragment, bundleOf(
                            "firstName" to it.firstName,
                            "secondName" to it.secondName,
                            "percentage" to it.percentage,
                            "result" to it.result
                        )
                    )
                })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}