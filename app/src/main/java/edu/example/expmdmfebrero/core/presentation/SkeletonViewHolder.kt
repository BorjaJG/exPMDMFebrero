package edu.example.expmdmfebrero.core.presentation



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.example.expmdmfebrero.R

class SkeletonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun showSkeleton() {
        TODO("Not yet implemented")
    }

    companion object {
        fun create(parent: ViewGroup): SkeletonViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_skeleton, parent, false)
            return SkeletonViewHolder(view)
        }
    }


}
