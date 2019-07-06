package com.strikalov.ayvazovskyproject.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.strikalov.ayvazovskyproject.model.entity.Picture
import com.strikalov.ayvazovskyproject.model.interactors.PictureInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class MainViewModel(val pictureInteractor: PictureInteractor) : ViewModel(){

    companion object {
        private const val TAG = "MAIN_VIEW_MODEL"
    }

    private var disposable: Disposable? = null

    private val pictureListLiveData = MutableLiveData<List<Picture>>().apply {
        value = ArrayList()
    }

    fun getPictureList(): LiveData<List<Picture>>{
        return pictureListLiveData
    }

    private val pictureIdLiveData = MutableLiveData<Int>()

    fun getPictureId(): LiveData<Int>{
        return pictureIdLiveData
    }

    private val pictureNameLiveData = MutableLiveData<String>()

    fun getPictureName(): LiveData<String>{
        return pictureNameLiveData
    }

    private val picturePlaceLiveData = MutableLiveData<String>()

    fun getPicturePlace(): LiveData<String>{
        return picturePlaceLiveData
    }

    private val pictureSizeLiveData = MutableLiveData<String>()

    fun getPictureSize(): LiveData<String>{
        return pictureSizeLiveData
    }

    private val pictureYearLiveData = MutableLiveData<String>()

    fun getPictureYear(): LiveData<String>{
        return pictureYearLiveData
    }

    private val pictureUrlLiveData = MutableLiveData<String>()

    fun getPictureUrl(): LiveData<String>{
        return pictureUrlLiveData
    }



    fun onCreateListFragment() {
        disposable?.dispose()

        if(pictureListLiveData.value!!.isEmpty()) {

            disposable = pictureInteractor.downloadPictureListFromServer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        pictureListLiveData.value = it
                        savePictureListInDatabase(it)
                    },
                    {
                        Log.i(TAG, it.toString())
                    }
                )
        }

    }

    fun onCreateDetailFragment(id: Int){
        Log.i(TAG, "onCreateDetailFragment() id = $id")
        disposable?.dispose()

        disposable = pictureInteractor.getPictureByIdFromDb(id.toLong())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    pictureNameLiveData.value = it.name
                    picturePlaceLiveData.value = it.place
                    pictureSizeLiveData.value = it.size
                    pictureYearLiveData.value = it.year
                    pictureUrlLiveData.value = it.url
                    Log.i(TAG, it.toString())
                },
                {
                    Log.i(TAG, it.toString())
                }
            )
    }

    private fun savePictureListInDatabase(pictureList: List<Picture>){

        disposable?.dispose()

        disposable = pictureInteractor.savePictureListInDb(pictureList)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {
                    Log.i(TAG, "savePictureListInDatabase complete successfully")
                },
                {
                    Log.i(TAG, it.toString())
                }
            )
    }

    fun onPictureClick(id: Int){
        Log.i(TAG, "onPictureClick() id = $id")
        pictureIdLiveData.value = id
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}