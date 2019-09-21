package com.nemesis.course.menuanborgesa.model.io

import com.google.gson.GsonBuilder
import com.nemesis.course.menuanborgesa.model.Contact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionManager {

    companion object{

        private val BASE_URL = "https://mi-docencia-benv.web.app"

        private fun create(): ContactsServices{

            val gson = GsonBuilder().create()

            val retrofilBuilder = Retrofit.Builder()
            retrofilBuilder.baseUrl(BASE_URL)
            retrofilBuilder.addConverterFactory(GsonConverterFactory.create(gson));

            val retrofit = retrofilBuilder.build()
            return retrofit.create(ContactsServices::class.java)
        }

        fun requestContacts(success: (ArrayList<Contact>) -> Unit, fail: (String) -> Unit ){

            val call = create().loadContacts()

            call.enqueue(object: Callback< ArrayList<Contact> >{

                override fun onFailure(call: Call<ArrayList<Contact>>, t: Throwable) {
                    fail(t.localizedMessage)
                }

                override fun onResponse(call: Call<ArrayList<Contact>>, response: Response<ArrayList<Contact>>) {
                    val array = response.body()
                    if(array != null){
                        success(array)
                    }else{
                        fail("No hay contactos")
                    }
                }

            })


        }

    }

}