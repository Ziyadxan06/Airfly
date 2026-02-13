package com.example.airflytravel

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = Color.parseColor("#207DFF")
                ds.isFakeBoldText = true
            }
        }

        spannable.setSpan(
            clickableSpan,
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