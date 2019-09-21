package com.nemesis.course.menuanborgesa.controllers


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nemesis.course.menuanborgesa.R
import com.nemesis.course.menuanborgesa.model.Contact
import com.nemesis.course.menuanborgesa.model.io.ConnectionManager


class ContactsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactsAdapter
    private var contacts = ArrayList<Contact>()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val view = inflater.inflate(R.layout.fragment_contacts, container, false)

        recyclerView = view.findViewById(R.id.contacts_recyclerview)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        setupFragment()
        loadContacts()
    }

    private fun setupFragment(){

        adapter = ContactsAdapter(contacts)

        val layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }


    private fun loadContacts(){

        ConnectionManager.requestContacts(success = {

            contacts.clear()
            contacts.addAll(it)
            adapter.notifyDataSetChanged()

        }, fail = {

        })


    }

}
