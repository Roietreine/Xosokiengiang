package rej.ano.xsotngng.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import rej.ano.xsotngng.R
import rej.ano.xsotngng.base.BaseFragment
import rej.ano.xsotngng.binding.viewBinding
import rej.ano.xsotngng.data.Data
import rej.ano.xsotngng.databinding.FragmentMainBinding

class MainFragment(
    private val listener: OnItemClickListener
): BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val topAdapter by lazy {
        TopAdapter(listener)
    }

    private val mainAdapter by lazy {
        MainAdapter(listener)
    }

    override fun setupViews() {
       with(binding){
           with(topRecycler){
               layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
               adapter = topAdapter
           }

           with(menuRecycler){
               layoutManager = LinearLayoutManager(requireContext())
               adapter = mainAdapter
           }

           textContent.text = Data.mainData
       }
    }

    override fun viewModelObservers() {}

}