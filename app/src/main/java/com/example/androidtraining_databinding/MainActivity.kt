package com.example.androidtraining_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private lateinit var lifecycleListener: LifecycleListener
    private lateinit var apiService: ApiService
    lateinit var adapter: CustomAdapter
    val list = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListView()

        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }

        apiService = get()
    }

    private fun setupListView() {
        for(i in 1..20) {
            list.add(Person(
                "Name$i",
                "Surname$i",
                i,
                "https://picsum.photos/200/300"
            ))
        }
        adapter = CustomAdapter(this, list)
        listView.adapter = adapter

        lifecycleListener = LifecycleListener(this, lifecycle) {
            Log.d("lifecycleListener", "callback")
        }
    }
}
