package com.example.network_db_task.presentation.userinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.network_db_task.databinding.FragmentUserInfoBinding
import com.example.network_db_task.domain.model.User

class UserInfoFragment : Fragment() {

    private var binding: FragmentUserInfoBinding? = null
    private var user: User? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserInfoBinding.inflate(LayoutInflater.from(context), container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveFromArguments()
        user?.let { binding?.initUi(it) }
    }

    private fun retrieveFromArguments(){
        arguments?.let {
            user = it.getParcelable<User>("info")
        }
    }
    private fun FragmentUserInfoBinding.initUi(user: User) {
        nameEditText.setText(user.name)
        dateEditText.setText(user.dateOfBirth)
        phoneEditText.setText(user.phone)
        emailEditText.setText(user.email)
        Glide.with(root.context).load(user.picUrl).into(imageOfUser)
    }

    companion object {
        fun newInstance(user: User) = UserInfoFragment().apply {
            arguments = Bundle().apply {
                putParcelable("info", user)
            }
        }
    }
}