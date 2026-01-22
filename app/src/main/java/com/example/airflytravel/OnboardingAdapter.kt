package com.example.airflytravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility

class OnboardingAdapter(
    val pages: List<OnboardingPage>,
    val onNext: (position: Int) -> Unit,
    val onSkip: () -> Unit
): RecyclerView.Adapter<OnboardingAdapter.PageViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding_page, parent, false)
        return PageViewHolder(view)
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

    class PageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imagePager = itemView.findViewById<ImageView>(R.id.imageViewPager)
        val cardTitlePager = itemView.findViewById<TextView>(R.id.cardTitle)
        val cardDescriptionPager = itemView.findViewById<TextView>(R.id.cardDescription)
        val btnNext = itemView.findViewById<Button>(R.id.btnNext)
        val btnSkip = itemView.findViewById<Button>(R.id.btnSkip)
    }
}