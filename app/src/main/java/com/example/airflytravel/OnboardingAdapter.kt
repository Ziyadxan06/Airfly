package com.example.airflytravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.airflytravel.databinding.ItemOnboardingPageBinding

class OnboardingAdapter(
    private val pages: List<OnboardingPage>,
    private val onNext: (position: Int) -> Unit,
    private val onSkip: () -> Unit
): RecyclerView.Adapter<OnboardingAdapter.PageViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PageViewHolder {
        val binding = ItemOnboardingPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PageViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PageViewHolder,
        position: Int
    ) {
        val page = pages[position]
        holder.imagePager.setImageResource(page.imageRes)
        holder.cardTitlePager.text = page.title
        holder.cardDescriptionPager.text = page.desc
        val pos = holder.bindingAdapterPosition

        if(page.isLast == true){
            holder.btnNext.text = "Get Started"
            holder.btnNext.setOnClickListener {
                onSkip.invoke()
            }
            holder.btnSkip.visibility = View.GONE
        }else{
            holder.btnNext.text = "Next"
            holder.btnNext.setOnClickListener {
                if(pos != RecyclerView.NO_POSITION){
                    onNext.invoke(pos)
                }
            }
            holder.btnSkip.visibility = View.VISIBLE
            holder.btnSkip.text = "Skip"
            holder.btnSkip.setOnClickListener {
                onSkip.invoke()
            }
        }
    }

    override fun getItemCount(): Int {
        return pages.size
    }

    class PageViewHolder(val binding: ItemOnboardingPageBinding): RecyclerView.ViewHolder(binding.root){
        val imagePager = binding.imageViewPager
        val cardTitlePager = binding.cardTitle
        val cardDescriptionPager = binding.cardDescription
        val btnNext = binding.btnNext
        val btnSkip = binding.btnSkip
    }
}