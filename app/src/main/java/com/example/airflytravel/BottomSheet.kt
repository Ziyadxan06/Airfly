package com.example.airflytravel

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.airflytravel.databinding.LayoutAuthOptionsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheet: BottomSheetDialogFragment() {

    private var _binding: LayoutAuthOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutAuthOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvRegisterMessage = binding.tvRegisterMessage

        val text = "Don’t have an account? Register"
        val spannable = SpannableString(text)

        val registerStart = text.indexOf("Register")
        val registerEnd = registerStart + "Register".length

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#207DFF")),
            registerStart,
            registerEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannable.setSpan(
            UnderlineSpan(),
            registerStart,
            registerEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvRegisterMessage.text = spannable
        tvRegisterMessage.movementMethod = LinkMovementMethod.getInstance()
        tvRegisterMessage.highlightColor = Color.TRANSPARENT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}