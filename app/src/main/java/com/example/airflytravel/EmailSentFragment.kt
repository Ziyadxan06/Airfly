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
import com.example.airflytravel.databinding.FragmentEmailSentBinding
import com.example.airflytravel.databinding.FragmentSignInBinding

class EmailSentFragment : Fragment() {
    private var _binding: FragmentEmailSentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEmailSentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvChangeEmail = binding.tvChangeEmail

        val tvText = "Did not receive the email? Check your Spam folder or try. Try another email address"

        val tvSpannable = SpannableString(tvText)

        val accountStart = tvText.indexOf("Try another email address")
        val accountEnd = accountStart + "Try another email address".length

        val tvClikableSpan = object : ClickableSpan(){
            override fun onClick(p0: View) {
                findNavController().navigate(R.id.action_emailSentFragment_to_forgotPasswordFragment )
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

        tvChangeEmail.text = tvSpannable
        tvChangeEmail.movementMethod = LinkMovementMethod.getInstance()
        tvChangeEmail.highlightColor = Color.TRANSPARENT
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}