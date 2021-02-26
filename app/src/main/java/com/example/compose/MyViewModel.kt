package com.example.compose

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel(){
    var num by mutableStateOf(0)
}