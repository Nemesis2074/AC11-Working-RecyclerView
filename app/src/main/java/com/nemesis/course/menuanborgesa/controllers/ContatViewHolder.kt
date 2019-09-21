package com.nemesis.course.menuanborgesa.controllers

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.nemesis.course.menuanborgesa.R
import com.nemesis.course.menuanborgesa.model.Contact
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_contact.view.*
import org.w3c.dom.Text

class ContatViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    val cardView:CardView = itemView.findViewById(R.id.contact_cardview)
    val imgPhoto:ImageView = itemView.findViewById(R.id.contact_photo)
    val txtName:TextView = itemView.findViewById(R.id.contact_name)
    val txtWork:TextView = itemView.findViewById(R.id.contact_work)
    val txtPhone:TextView = itemView.findViewById(R.id.contact_phone)
    val btnCall:ImageButton = itemView.findViewById(R.id.contact_call_button)
    val btnEmail:ImageButton = itemView.findViewById(R.id.contact_email_button)


    fun bindData(contact: Contact){

        Picasso.get().load(contact.photo).into(imgPhoto)

        txtName.text = contact.name
        txtWork.text = contact.work
        txtPhone.text = contact.phone


    }

}