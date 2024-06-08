package com.example.network_db_task.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import android.os.Bundle
import com.example.network_db_task.R
import com.example.network_db_task.presentation.userslist.UserListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            replace<UserListFragment>(R.id.fragment_view)
            setReorderingAllowed(true)
        }
    }
}