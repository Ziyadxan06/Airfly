package com.example.airflytravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.airflytravel.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var pages: List<OnboardingPage>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.onboardingPager

        pages = listOf(
            OnboardingPage(R.drawable.illustration_onboarding_1, "Plan a Trip", "Plan trip to more 90 countries with few taps on your mobile screen.", false),
            OnboardingPage(R.drawable.illustration_onboarding_2, "Start Your Journey", "Hassle-free and quick flight booking to and one of the 250 destinations.", false),
            OnboardingPage(R.drawable.illustration_onboarding_3, "Trip Schedule", "Hassle-free and quick flight booking to and one of the 250 destinations.", true)
        )

        val adapter = OnboardingAdapter(
            pages,

            onNext = { position ->
                viewPager.currentItem = position+1
            },

            onSkip = {
                findNavController().navigate(R.id.action_onboardingFragment2_to_loginFragment)
            }
        )

        viewPager.adapter = adapter


    }
}