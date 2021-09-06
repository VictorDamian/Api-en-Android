package com.vmdb.myapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vmdb.myapi.DataAccess.Repository.Adapters.UserAdapter
import com.vmdb.myapi.DataAccess.Repository.ViewModels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userAdapter: UserAdapter
    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitRecyclerView()
        InitUserViewModel()
        SearchUser()
    }
    private fun InitRecyclerView(){
        userRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity,
                DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            userAdapter = UserAdapter()
            adapter = userAdapter
        }
    }
    private fun SearchUser(){
        btnSearch.setOnClickListener {
            if(!TextUtils.isEmpty(edtSearch.text.toString())){
                userViewModel.GetUserName(edtSearch.text.toString())
            }else{
                userViewModel.GetUserList()
            }

        }
    }
    private fun InitUserViewModel(){
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.GetAllWoksObservable().observe(this, {
            if (it != null){
                userAdapter.userList = it.data.toMutableList()
                userAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this@MainActivity,
                    "No fund",Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.GetUserList()
    }
}