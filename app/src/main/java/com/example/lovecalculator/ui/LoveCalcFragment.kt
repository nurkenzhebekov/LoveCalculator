package com.example.lovecalculator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.RetrofitService
import com.example.lovecalculator.databinding.FragmentLoveCalcBinding
import com.example.lovecalculator.model.LoveCalcModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalcFragment : Fragment() {

    private var _binding: FragmentLoveCalcBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoveCalcBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btCalculate.setOnClickListener {
                RetrofitService.api.getLoveCalc(
                    firstName = edtFirstName.text.toString(),
                    secondName = edtSecondName.text.toString()
                ).enqueue(object : Callback<LoveCalcModel>{
                    override fun onResponse(call: Call<LoveCalcModel>, response: Response<LoveCalcModel>) {
                        val data = response.body()
                        if (data != null) {
                            findNavController().navigate(
                                R.id.calcResultFragment, bundleOf(
                                    "firstName" to data.firstName,
                                    "secondName" to data.secondName,
                                    "percentage" to data.percentage,
                                    "result" to data.result
                                )
                            )
                        }
                    }

                    override fun onFailure(call: Call<LoveCalcModel>, error: Throwable) {
                        Log.e("loveError", "onFailure: ${error.message}")
                    }
                })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}