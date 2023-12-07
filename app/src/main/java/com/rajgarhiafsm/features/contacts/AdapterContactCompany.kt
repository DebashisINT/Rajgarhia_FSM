package com.rajgarhiafsm.features.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.rajgarhiafsm.R
import com.rajgarhiafsm.features.addAttendence.model.LocationDataModel
import kotlinx.android.synthetic.main.row_company_name.view.tv_row_comp_name
import java.util.HashSet

class AdapterContactCompany(var mContext:Context,var companyNameL:ArrayList<String>,var listner:onClick) :
    RecyclerView.Adapter<AdapterContactCompany.ContactCompanyViewHolder>(), Filterable {

    private val layoutInflater: LayoutInflater by lazy {
        LayoutInflater.from(mContext)
    }

    private lateinit var mList:ArrayList<String>
    private lateinit var filterL:ArrayList<String>
    private lateinit var tempL:ArrayList<String>

    init {
        mList = ArrayList()
        mList.addAll(companyNameL)

        tempL = ArrayList()
        tempL.addAll(companyNameL)

        filterL= ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactCompanyViewHolder {
        val v = layoutInflater.inflate(R.layout.row_company_name, parent, false)
        return ContactCompanyViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContactCompanyViewHolder, position: Int) {
        holder.bindItems()
    }

    override fun getItemCount(): Int {
        return mList?.size!!
    }

    inner class ContactCompanyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindItems(){
            itemView.tv_row_comp_name.text = mList.get(adapterPosition)
            itemView.tv_row_comp_name.setOnClickListener {
                listner.onNameClick(mList.get(adapterPosition))
            }
        }
    }

    interface onClick{
        fun onNameClick(obj:String)
        fun onNoData(nodata:Boolean)
    }

    override fun getFilter(): Filter {
        return SearchFilter()
    }

    inner class SearchFilter : Filter() {
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val results = FilterResults()

            filterL?.clear()

            tempL?.indices!!
                .filter { tempL?.get(it)?.toLowerCase()?.contains(p0?.toString()?.toLowerCase()!!)!! }
                .forEach { filterL?.add(tempL?.get(it)!!) }

            results.values = filterL
            results.count = filterL?.size!!

            return results
        }

        override fun publishResults(p0: CharSequence?, results: FilterResults?) {

            try {
                filterL = (results?.values as ArrayList<String>?)!!
                mList?.clear()
                val hashSet = HashSet<String>()
                if (filterL != null) {
                    filterL?.indices!!
                        .filter { hashSet.add(filterL?.get(it)!!) }
                        .forEach { mList?.add(filterL?.get(it)!!) }

                    if(filterL.size==0){
                        listner.onNoData(true)
                    }

                    notifyDataSetChanged()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}