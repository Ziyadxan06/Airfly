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
import android.widget.Toast
import androidx.core.text.set
import androidx.navigation.fragment.findNavController
import com.example.airflytravel.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCheckBox = binding.tvCheckBox
        val tvExistAccount = binding.accountExistsMessageSignUp

        val cbText = "I agree with Terms & Conditions"
        val tvText = "have an account? Sign In"

        val cbSpannable = SpannableString(cbText)
        val tvSpannable = SpannableString(tvText)

        val checkStart = cbText.indexOf("Terms & Conditions")
        val checkEnd = checkStart + "Terms & Conditions".length

        val accountStart = tvText.indexOf("Sign In")
        val accountEnd = accountStart + "Sign In".length

        val cbClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Toast.makeText(requireContext(), "Terms", Toast.LENGTH_SHORT)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#207DFF")
                ds.isFakeBoldText = true
            }
        }

        val tvClikableSpan = object : ClickableSpan(){
            override fun onClick(p0: View) {
                findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#207DFF")
                ds.isFakeBoldText = true
                ds.isUnderlineText = true
            }
        }

        cbSpannable.setSpan(
            cbClickableSpan,
            checkStart,
            checkEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvSpannable.setSpan(
            tvClikableSpan,
            accountStart,
            accountEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvCheckBox.text = cbSpannable
        tvCheckBox.movementMethod = LinkMovementMethod.getInstance()
        tvCheckBox.highlightColor = Color.TRANSPARENT

        tvExistAccount.text = tvSpannable
        tvExistAccount.movementMethod = LinkMovementMethod.getInstance()
        tvCheckBox.highlightColor = Color.TRANSPARENT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}