package raum.muchbeer.cinemaktx.data.repository.cinema.datasource

import android.util.Log
import androidx.paging.PositionalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.data.repository.cinema.impl.CinemaRepositoryImpl
import javax.inject.Inject

class CinemaRemotePagingDataSource
    @Inject
    constructor(
        private val cinemaRepositoryImpl: CinemaRepositoryImpl
    ): PositionalDataSource<CinemaModel>()  {

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<CinemaModel>
    ) {
        Log.d("DATA_SOURCE", "loadInitial, requestedStartPosition = ${params.requestedStartPosition}, requestedLoadSize = ${params.requestedLoadSize}")
        CoroutineScope(Dispatchers.IO).launch {
            /*val callResult =  cinemaRepositoryImpl.retrieveCinemaFromAPI(params.requestedLoadSize)

            if (callResult !=null) {
                Log.d("DATA_SOURCE", "loaded datas are : ${callResult}")

                callback.onResult(callResult!!.toMutableList(),0)
            } else {
                Log.e("RESPONSE", "onResponse error}")
            }*/
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<CinemaModel>) {
        Log.d("DATA_SOURCE", "loadRange, startPosition = ${params.startPosition}, loadSize = ${params.loadSize}")
      /*  CoroutineScope(Dispatchers.IO).launch {
            val callResult =  cinemaRepositoryImpl.retrieveCinemaFromAPI(params.loadSize)

            if (callResult !=null) {
                Log.d("DATA_SOURCE", "loaded datas are : ${callResult}")

                callback.onResult(callResult!!.toMutableList())
            } else {
                Log.e("RESPONSE", "onResponse error}")
            }*/
        }

    }


