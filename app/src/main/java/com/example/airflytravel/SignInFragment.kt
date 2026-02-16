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
import com.example.airflytravel.databinding.FragmentSignInBinding
import com.example.airflytravel.databinding.FragmentSignUpBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvExistsAccount = binding.accountExistsMessageSignIn

        val tvText = "Don't have an account? Sign Up"

        val tvSpannable = SpannableString(tvText)

        val accountStart = tvText.indexOf("Sign Up")
        val accountEnd = accountStart + "Sign Up".length

        val tvClikableSpan = object : ClickableSpan(){
            override fun onClick(p0: View) {
                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment )
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