package com.example.eventbusarctecture

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var call:Button
    lateinit var callLog:Button
    lateinit var contact:Button
    lateinit var browser:Button
    lateinit var gallary:Button
    lateinit var camera:Button
    lateinit var map:Button

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.call ->{
                var a:EditText = findViewById(R.id.phone)
                Toast.makeText(this,"call",Toast.LENGTH_SHORT)
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:"+ a.text.toString())
                startActivity(intent)
            }

            R.id.call_log ->{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.type = CallLog.Calls.CONTENT_TYPE
                startActivity(intent)
            }

            R.id.contact ->{
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = ContactsContract.Contacts.CONTENT_TYPE
                startActivity(intent)
            }

            R.id.browser ->{
                val a = findViewById<EditText>(R.id.url)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://"+a.text.toString())
                startActivity(intent)
            }

            R.id.gallary ->{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("content://media/external/images/media/")
                startActivity(intent)
            }
            R.id.camera ->{
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
            }

            R.id.map ->{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("geo: 0,0 ")


                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        call = findViewById(R.id.call)
        callLog =findViewById(R.id.call_log)
        contact = findViewById(R.id.contact)
        browser = findViewById(R.id.browser)
        gallary = findViewById(R.id.gallary)
        camera = findViewById(R.id.camera)
        map = findViewById(R.id.map)

        call.setOnClickListener (this)
        callLog.setOnClickListener(this)
        contact.setOnClickListener(this)
        browser.setOnClickListener(this)
        gallary.setOnClickListener(this)
        camera.setOnClickListener(this)
        map.setOnClickListener(this)

    }


}
