package com.taurus.modernandroiddevelopmentkata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class MainViewModel : ViewModel(){

  val currentNavController = MutableLiveData<NavController>()

}
