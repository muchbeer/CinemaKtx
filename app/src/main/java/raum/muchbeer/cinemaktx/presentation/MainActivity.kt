package raum.muchbeer.cinemaktx.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import raum.muchbeer.cinemaktx.R
import raum.muchbeer.cinemaktx.databinding.ActivityMainBinding
import raum.muchbeer.cinemaktx.presentation.viewholder.CinemaAdapter
import raum.muchbeer.cinemaktx.presentation.viewmodel.CinemaViewModel


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  /*  @Inject
    lateinit var cinemaVMFactory : CinemaViewModelFactory*/


  private lateinit var cinemaViewModel : CinemaViewModel
   // private val cinemaViewModel : CinemaViewModel by viewModels()
  private lateinit var adapter : CinemaAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
             
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        cinemaViewModel = ViewModelProvider(this).get(CinemaViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CinemaAdapter()
        binding.movieRecyclerView.adapter = adapter
        loadMoviesData()
    }

    private fun loadMoviesData() {
      binding.movieProgressBar.visibility = View.VISIBLE
        cinemaViewModel.retrieveCinemaMovie().observe(this, Observer {
            Log.d("GadielActivity", "LiveData Reached Main Activity")
            if (it!=null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE

            } else {
                binding.movieProgressBar.visibility=View.VISIBLE
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.refresh, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menu_refresh -> {
                Log.i("MainActivity : ", "success")
                return true
            }            

        }
        return super.onOptionsItemSelected(item)
    }
}