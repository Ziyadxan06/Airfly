package com.example.airflytravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2

class OnboardingFragment : Fragment() {

    lateinit var pages: List<OnboardingPage>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.onboardingPager)

        pages = listOf(
            OnboardingPage(R.drawable.ic_launcher_background, "Salam", "necesiz", false),
            OnboardingPage(R.drawable.ic_launcher_background, "Salam2", "necesiz", false),
            OnboardingPage(R.drawable.ic_launcher_background, "Salam3", "necesiz", true)
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