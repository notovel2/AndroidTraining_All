package com.example.androidtraining_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private lateinit var lifecycleListener: LifecycleListener
    lateinit var adapter: CustomAdapter
    private lateinit var contributorViewModel: ContributorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
        initViewModel()
        setupListView()
        contributorViewModel.searchContributors()
    }

    private fun initViewModel() {
        val contributorViewModelFactory = ContributorViewModelFactory(get())
        contributorViewModel = ViewModelProviders
            .of(this, contributorViewModelFactory)
            .get(ContributorViewModel::class.java)

    }

    private fun setupListView() {
        contributorViewModel.getContributors()
            .observe(
                this,
                Observer { contributor ->
                    contributor.let {
                        updateListView(it)
                    }
                }
            )

        adapter = CustomAdapter(
            this,
            ArrayList(contributorViewModel.getContributors().value ?: listOf()))
        listView.adapter = adapter
        lifecycleListener = LifecycleListener(this, lifecycle) {
            Log.d("lifecycleListener", "callback")
        }
    }

    private fun updateListView(contributors: List<Contributor>) {
        adapter.list.addAll(contributors)
        adapter.notifyDataSetChanged()
    }
}
