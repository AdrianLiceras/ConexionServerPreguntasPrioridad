package com.example.conexionserverpreguntasprioridad



import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.*
import java.io.IOException
class MainActivityViewModel: ViewModel() {
    private val _isVisible by lazy { MediatorLiveData<Boolean>() }
    val isVisible : LiveData<Boolean>
        get() = _isVisible
    suspend fun setIsVisibleInMainThread(value : Boolean) = withContext(Dispatchers.Main){
        _isVisible.value = value
    }
    private val _responseText by lazy { MediatorLiveData<String>() }
    val responseText : LiveData<String>
        get() = _responseText
    private val _user by lazy { MediatorLiveData<User>() }
    val user:LiveData<User>
    get() = _user
    suspend fun setResponseTextInMainThread(value : String) = withContext(Dispatchers.Main){
        _responseText.value = value
    }

    fun getPreguntas(){

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                setIsVisibleInMainThread(true)


                val client = OkHttpClient()

                val request = Request.Builder()
                request.url("http://10.0.2.2:8081/inicio/1")


                val call = client.newCall(request.build())
                call.enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        println(e.toString())
                        CoroutineScope(Dispatchers.Main).launch {

                            setResponseTextInMainThread("Algo ha ido mal")
                            setIsVisibleInMainThread(false)
                        }

                    }

                    override fun onResponse(call: Call, response: Response) {
                        println(response.toString())
                        response.body?.let { responseBody ->
                            val body = responseBody.string()
                           // println(body)
                            val gson = Gson()

                            val userRes = gson.fromJson(body, User::class.java)

                            println(userRes)

                            CoroutineScope(Dispatchers.Main).launch {

                                setIsVisibleInMainThread(false)
                                _user.value=userRes
                              //  println(userRes.toString())
                                setResponseTextInMainThread(userRes.toString())
                            }
                        }
                    }
                })
            }
        }
    }
}
