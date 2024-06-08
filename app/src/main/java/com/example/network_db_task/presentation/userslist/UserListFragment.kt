package com.example.network_db_task.presentation.userslist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.network_db_task.R
import com.example.network_db_task.data.localdatabase.DatabaseBuilder
import com.example.network_db_task.data.localdatabase.UserDaoHelperImpl
import com.example.network_db_task.data.network.ApiHelperImpl
import com.example.network_db_task.domain.repository.MainRepository
import com.example.network_db_task.data.network.RetrofitBuilder
import com.example.network_db_task.databinding.FragmentUserListBinding
import com.example.network_db_task.domain.model.User
import com.example.network_db_task.presentation.userinfo.UserInfoFragment
import kotlinx.coroutines.launch


class UserListFragment : Fragment() {

    private val adapter by lazy {
        UserRecyclerAdapter(onItemClicked)
    }

    private val onItemClicked: (User) -> Unit = { item ->
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.fragment_view, UserInfoFragment.newInstance(item))
            addToBackStack(null)
            commit()
        }
    }

    private val viewModel: ListViewModel by viewModels {
        ListViewModel.provideFactory(
            MainRepository(
                ApiHelperImpl(RetrofitBuilder.apiService),
                UserDaoHelperImpl(DatabaseBuilder.getDatabase(requireContext().applicationContext)),
            ),
            activity?.application
        )
    }

    private var binding: FragmentUserListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(LayoutInflater.from(context), container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "${viewModel.usersDataState.value}")
        initUi()
        dataListener()
    }

    private fun initUi() {
        binding?.userList?.adapter = adapter
    }

    private fun dataListener() {
        lifecycleScope.launch {
            viewModel.usersDataState.collect { value ->
                adapter.submitList(value.list)
            }
        }

    }

}