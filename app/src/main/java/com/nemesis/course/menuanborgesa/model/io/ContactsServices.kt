package com.nemesis.course.menuanborgesa.model.io

import com.nemesis.course.menuanborgesa.model.Contact
import retrofit2.Call
import retrofit2.http.GET

interface ContactsServices {

    @GET("/demos/contacts.json")
    fun loadContacts(): Call< ArrayList<Contact> >

    @GET("/demos/kities.json")
    fun loadKitties(): Call< ArrayList<Contact> >


}