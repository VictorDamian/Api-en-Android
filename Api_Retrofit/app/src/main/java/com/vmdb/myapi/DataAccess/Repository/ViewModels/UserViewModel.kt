package com.vmdb.myapi.DataAccess.Repository.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vmdb.myapi.DataAccess.Repository.Contracts.IUserRepository
import com.vmdb.myapi.DataAccess.Repository.Models.UserList
import com.vmdb.myapi.DataAccess.Repository.RepositoryRF
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    var allUsers: MutableLiveData<UserList>
    init {
        allUsers = MutableLiveData()
    }
    fun GetAllWoksObservable():MutableLiveData<UserList>{
        return allUsers
    }
    fun GetUserList(){
        val repository = RepositoryRF.GetConnection().create(IUserRepository::class.java)
        val call = repository.GetAllUsers()
        call.enqueue(object : Callback<UserList> {
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                allUsers.postValue(null)
            }
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                allUsers.postValue(response.body())
            }
        })
    }
    fun GetUserName(name: String){
        val repository = RepositoryRF.GetConnection().create(IUserRepository::class.java)
        val call = repository.GetUserName(name)
        call.enqueue(object : Callback<UserList> {
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                allUsers.postValue(null)
            }
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                allUsers.postValue(response.body())
            }
        })
    }
}