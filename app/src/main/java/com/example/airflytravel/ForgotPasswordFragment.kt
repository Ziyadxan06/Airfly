package com.example.airflytravel

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.airflytravel.databinding.FragmentForgotPasswordBinding
import com.example.airflytravel.databinding.FragmentSignInBinding

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvExistsAccount = binding.accountExistsMessageForgotPassword

        val tvText = "Back to Sign in"

        val tvSpannable = SpannableString(tvText)

        val accountStart = tvText.indexOf("Sign in")
        val accountEnd = accountStart + "Sign in".length

        val tvClikableSpan = object : ClickableSpan(){
            override fun onClick(p0: View) {
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#207DFF")
                ds.isFakeBoldText = true
                ds.isUnderlineText = true
            }
        }

        tvSpannable.setSpan(
            tvClikableSpan,
            accountStart,
            accountEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvExistsAccount.text = tvSpannable
        tvExistsAccount.movementMethod = LinkMovementMethod.getInstance()
        tvExistsAccount.highlightColor = Color.TRANSPARENT
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}