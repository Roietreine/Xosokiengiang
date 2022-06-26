package rej.ano.xsotngng.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rej.ano.xsotngng.R
import rej.ano.xsotngng.data.Data
import rej.ano.xsotngng.databinding.ItemMainTopMenuBinding

class TopAdapter(
    private val listener: OnItemClickListener
): RecyclerView.Adapter<TopAdapter.Holder>() {

    val data = Data.data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAdapter.Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_main_top_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: TopAdapter.Holder, position: Int) {
        val newData = data[position]
        with(holder.binding){
            menuTitle.text = newData.title
            root.setOnClickListener { listener.onItemCLick(position + 1) }
        }
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemMainTopMenuBinding.bind(itemView)
        }
    }


}