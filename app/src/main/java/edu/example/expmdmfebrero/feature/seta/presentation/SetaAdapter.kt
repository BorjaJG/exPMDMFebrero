package edu.example.expmdmfebrero.feature.seta.presentation

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.example.expmdmfebrero.core.presentation.SkeletonViewHolder
import edu.example.expmdmfebrero.feature.seta.domain.Seta

class SetaAdapter(private var myItemList: MutableList<Seta>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_VIEW_TYPE = 0
    private val LOADING_VIEW_TYPE = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ITEM_VIEW_TYPE -> SetaViewHolder.create(parent)
            LOADING_VIEW_TYPE -> SkeletonViewHolder.create(parent)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SetaViewHolder -> holder.bind(myItemList[position])
            is SkeletonViewHolder -> holder.showSkeleton()
        }
    }


    override fun getItemCount(): Int {
        return myItemList.size
    }


    override fun getItemViewType(position: Int): Int {
        return if (myItemList[position].nombre == "loading") {
            LOADING_VIEW_TYPE
        } else {
            ITEM_VIEW_TYPE
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<Seta>) {
        myItemList.clear()
        myItemList.addAll(newItems)
        notifyDataSetChanged()
    }


    fun showLoading() {
        val loadingItem = Seta("loading", "", "")
        myItemList.add(loadingItem)
        notifyItemInserted(myItemList.size - 1)
    }


    fun hideLoading() {
        val lastIndex = myItemList.size - 1
        if (lastIndex >= 0 && myItemList[lastIndex].nombre == "loading") {
            myItemList.removeAt(lastIndex)
            notifyItemRemoved(lastIndex)
        }
    }
}
