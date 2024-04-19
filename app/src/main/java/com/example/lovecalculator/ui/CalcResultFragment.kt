package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentCalcResultBinding

class CalcResultFragment : Fragment() {

    private var _binding: FragmentCalcResultBinding? = null
    private val binding get() = _binding!!

    private val args: CalcResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCalcResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btTryAgain.setOnClickListener {
                findNavController().navigate(R.id.loveCalcFragment)
            }
            history.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    private fun setData() {
        with(binding) {
            tvFirstNameResult.text = args.firstName
            tvSecondNameResult.text = args.secondName
            tvPercentageResult.text = args.percentage
            tvLoveCalcResult.text = args.result
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}