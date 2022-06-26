package rej.ano.xsotngng.fragments

import rej.ano.xsotngng.R
import rej.ano.xsotngng.base.BaseFragment
import rej.ano.xsotngng.binding.viewBinding
import rej.ano.xsotngng.data.DataModel
import rej.ano.xsotngng.databinding.FragmentDetailsBinding

class DetailsFragment(
    private val data : DataModel
): BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details){

    override val binding: FragmentDetailsBinding by viewBinding(FragmentDetailsBinding::bind)

    override fun setupViews() {
        with(binding){
            menuTitle.text = data.title
            textContent.text = data.desc
            banner.setBackgroundResource(data.image)
        }
    }

    override fun viewModelObservers() {
    }
}