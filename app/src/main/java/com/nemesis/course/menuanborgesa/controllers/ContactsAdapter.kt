package com.nemesis.course.menuanborgesa.controllers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nemesis.course.menuanborgesa.R
import com.nemesis.course.menuanborgesa.model.Contact

class ContactsAdapter(val contacts: ArrayList<Contact>): RecyclerView.Adapter<ContatViewHolder>() {

    //Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return contacts.size
    }

    //Configurar el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ContatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_contact, parent, false);
        val viewHolder = ContatViewHolder(view)
        return viewHolder
    }

    //Mostramos datos
    override fun onBindViewHolder(viewHolder: ContatViewHolder, position: Int) {
        val contact = contacts[position]
        viewHolder.bindData(contact)
    }


}