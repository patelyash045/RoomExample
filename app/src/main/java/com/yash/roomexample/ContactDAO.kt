package com.yash.roomexample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO{

    // Long lasting task execution on Background
    // we have to use coroutine method
    //It is very popular method

    @Insert
    suspend fun insertContact(contact: Contact) //suspend function is use for function background thread Execution
    //because At foreground Execution time occurred Exceptions

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    //LiveData is Always execute on Background Thread
    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<Contact>>
    // for All Get function we have to use the LiveData
}