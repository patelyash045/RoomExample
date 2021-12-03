package com.yash.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,
            ContactDatabase::class.java,
            "contactDB").build()  //that is not good method Mostly use the single tone method
        //Singleton means whole App time only one database instance is use in the App


        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"John","9988776655"))
        }



    }
}