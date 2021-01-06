package raum.muchbeer.cinemaktx.presentation.viewholder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import raum.muchbeer.cinemaktx.R
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.databinding.MovieItemBinding

class CinemaAdapter() : RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>() {
        private val movieList = ArrayList<CinemaModel>()
               fun setList(movies : List<CinemaModel>) {
                   movieList.clear()
                   movieList.addAll(movies)
               }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding : MovieItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.movie_item,
            parent,
            false  )

        return CinemaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        Log.d("CinemaAdapter: ", "Movie list Adapter is: ${movieList[position].title}")
      holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {  return  movieList.size  }


    class CinemaViewHolder(val bindingVH: MovieItemBinding) : RecyclerView.ViewHolder(bindingVH.root) {

        fun bind(movie:CinemaModel) {
            bindingVH.titleTextView.text = movie.title
            bindingVH.descriptionTextView.text = movie.overview
            val posterPath = "https://image.tmdb.org/t/p/w500"+ movie.posterPath

            Glide.with(bindingVH.imageView.context)
                .load(posterPath)
                .into(bindingVH.imageView)
        }

    }
}