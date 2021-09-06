package com.vmdb.myapi.DataAccess.Repository.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vmdb.myapi.DataAccess.Repository.Models.User
import com.vmdb.myapi.R
import kotlinx.android.synthetic.main.users_list.view.*

class UserAdapter: RecyclerView.Adapter<UserAdapter.HolderUser>() {
    var userList = mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderUser {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.users_list, parent, false)
        return HolderUser(inflater)
    }

    override fun onBindViewHolder(holder: HolderUser, position: Int) {
        holder.HolderUser(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class HolderUser(v: View): RecyclerView.ViewHolder(v){
        val txtname = v.txtName
        val email = v.txtEmail
        val  status = v.txtStatus
        fun HolderUser(data: User){
            txtname.text = data.name
            email.text = data.email
            status.text = data.status
        }
    }
}