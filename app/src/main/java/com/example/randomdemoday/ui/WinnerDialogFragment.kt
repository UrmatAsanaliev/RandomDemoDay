package com.example.randomdemoday.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.randomdemoday.R
import com.example.randomdemoday.databinding.FragmentWinnerDialogBinding

class WinnerDialogFragment(
    private val image: String,
    private val name: String,
    private val level: String
) : DialogFragment() {
    private lateinit var binding: FragmentWinnerDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWinnerDialogBinding.inflate(inflater, container, false)
//        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_card)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.winnerImg.loadImage(image)
            binding.winnerTvName.text = name
            binding.txtLevel.text = "Уровень: $level"

    }
}