package com.bitcodetech.recyclerview3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bitcodetech.recyclerview3.R
import com.bitcodetech.recyclerview3.models.Advertisement
import com.bitcodetech.recyclerview3.models.CallInfo

class CallsAdapter(
    private val callsInfo: ArrayList<CallInfo>,
    private val advertisements: ArrayList<Advertisement>
) : RecyclerView.Adapter<ViewHolder>() {

    interface OnAdvertisementClickListener {
        fun onAdvertisementClick(advertisement: Advertisement, advPosition: Int)
    }

    var onAdvertisementClickListener: OnAdvertisementClickListener? = null

    interface OnCallInfoClickListener {
        fun onContactImageClick(callInfo: CallInfo, callPosition: Int)
        fun onContactNameClick(callInfo: CallInfo, callPosition: Int)
        fun onContactNumberClick(callInfo: CallInfo, callPosition: Int)

    }

    var onCallInfoClickListener: OnCallInfoClickListener? = null


    inner class CallInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgContact: ImageView
        val txtName: TextView
        val txtNumber: TextView

        init {
            imgContact = view.findViewById(R.id.imgContact)
            txtName = view.findViewById(R.id.txtName)
            txtNumber = view.findViewById(R.id.txtNumber)

            imgContact.setOnClickListener {
                onCallInfoClickListener?.onContactImageClick(
                    callsInfo[adapterPosition - adapterPosition / 3],
                    adapterPosition - adapterPosition / 3
                )
            }

            txtName.setOnClickListener {
                onCallInfoClickListener?.onContactNameClick(
                    callsInfo[adapterPosition - adapterPosition / 3],
                    adapterPosition - adapterPosition / 3
                )
            }

            txtNumber.setOnClickListener {
                onCallInfoClickListener?.onContactNumberClick(
                    callsInfo[adapterPosition - adapterPosition / 3],
                    adapterPosition - adapterPosition / 3
                )
            }
        }
    }

    inner class AdvertisementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAdv: ImageView
        val txtAdvTitle: TextView

        init {
            imgAdv = view.findViewById(R.id.imgAdv)
            txtAdvTitle = view.findViewById(R.id.txtAdvTitle)

            itemView.setOnClickListener {
                onAdvertisementClickListener?.onAdvertisementClick(
                    advertisements[adapterPosition/3 - 1],
                    adapterPosition/3 - 1
                )
            }
        }
    }


    override fun getItemCount(): Int {
        return callsInfo.size + advertisements.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 1
        }
        if (position % 3 != 0) {
            return 1
        }

        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        if (viewType == 1) {
            return CallInfoViewHolder(
                layoutInflater.inflate(R.layout.call_info_view, null)
            )
        }

        return AdvertisementViewHolder(
            layoutInflater.inflate(R.layout.advertisement_view, null)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (holder is CallInfoViewHolder) {
            //bind call info data
            val callInfo = callsInfo[position - position / 3]
            if (callInfo.imageId != null) {
                holder.imgContact.setImageResource(callInfo.imageId)
            } else {
                holder.imgContact.setImageResource(R.drawable.person)
            }
            if (callInfo.name != null) {
                holder.txtName.text = callInfo.name
                holder.txtName.visibility = View.VISIBLE
            } else {
                holder.txtName.visibility = View.GONE
            }
            holder.txtNumber.text = callInfo.number
        }

        if (holder is AdvertisementViewHolder) {
            //bind adv data
            val adv = advertisements[position / 3 - 1]
            holder.imgAdv.setImageResource(adv.imageId)
            holder.txtAdvTitle.text = adv.title
        }

    }

}



