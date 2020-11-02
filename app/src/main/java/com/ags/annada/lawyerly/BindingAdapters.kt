package com.ags.annada.lawyerly

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ags.annada.lawyerly.lawyers.LawyersAdapter
import com.ags.annada.lawyerly.model.Lawyer

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Lawyer>?) {
    items?.let {
        (listView.adapter as LawyersAdapter).submitList(items)
    }
}

@BindingAdapter("app:src")
fun setImageViewResource(imageView: ImageView, imageName: String) {
    val context = imageView.context
    val packageName = context.packageName
    val resId: Int = context.resources.getIdentifier(imageName, "drawable", packageName)
    imageView.setImageResource(resId)
}