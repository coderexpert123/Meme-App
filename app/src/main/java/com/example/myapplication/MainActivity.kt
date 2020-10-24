package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // var progressBar: ProgressBar = findViewById(R.id.p)
        loadmeme()
    }
    private fun loadmeme(){


        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
        val imageView: ImageView = findViewById(R.id.image_view)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->


                    val  url=response.getString("url")
                    Glide.with(this).load(url).into(imageView);
                },
                Response.ErrorListener { error ->
                    // TODO: Handle error
                }
        )


        queue.add(jsonObjectRequest)
    }
    fun sare(view: View) {}
    fun ext(view: View) {
        loadmeme()
    }
}