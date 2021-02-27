package br.com.tecnomotor.utils.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import br.com.tecnomotor.model.interfaceDate.OnEditTextChanged
import com.google.android.material.textfield.TextInputEditText

class StringFilterAdapterTypeAutomobileManufacture(
    private val filterList: ArrayList<String>,
    val context: Context,
    val textInputEditText: TextInputEditText
) : RecyclerView.Adapter<StringFilterAdapterTypeAutomobileManufacture.ViewHolder>() {
    private var lastCheckedPosition = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StringFilterAdapterTypeAutomobileManufacture.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_type_automobile_manufacturer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StringFilterAdapterTypeAutomobileManufacture.ViewHolder,
        position: Int
    ) {
        holder.typeAutomobileManufacturer.text = filterList[position]
        holder.radioButton.isChecked = position == lastCheckedPosition
        holder.radioButton.setOnClickListener {
            if (position == lastCheckedPosition) {
                holder.radioButton.isChecked = false
                lastCheckedPosition = -1
            } else {
                lastCheckedPosition = position
                notifyDataSetChanged()
            }

            textInputEditText.setText(filterList[position])
        }


    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val typeAutomobileManufacturer: TextView =
            view.findViewById<View>(R.id.txt_type_automobile_manufacturer) as TextView
        var radioButton: RadioButton =
            view.findViewById<View>(R.id.radio_button_type_automobile_manufacturer_recycler) as RadioButton
    }
}