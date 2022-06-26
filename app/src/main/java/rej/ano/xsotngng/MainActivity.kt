package rej.ano.xsotngng

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import rej.ano.xsotngng.binding.viewBinding
import rej.ano.xsotngng.data.Data
import rej.ano.xsotngng.databinding.ActivityMainBinding
import rej.ano.xsotngng.fragments.DetailsFragment
import rej.ano.xsotngng.fragments.MainFragment
import rej.ano.xsotngng.fragments.OnItemClickListener

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var fragments: List<Fragment>

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        fragments = listOf(
            MainFragment(this),
            DetailsFragment(Data.data[0]),
            DetailsFragment(Data.data[1]),
            DetailsFragment(Data.data[2]),
            DetailsFragment(Data.data[3])
        )

        viewPagerAdapter = ViewPagerAdapter(this, fragments)

        with(binding){
            with(viewPager){
                adapter = viewPagerAdapter
                isUserInputEnabled = false
                offscreenPageLimit = 4

                registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        hideBottomNav(position == 0)
                        when(position){
                            0 -> bottomNavigationView.selectedItemId = R.id.main
                            1 -> bottomNavigationView.selectedItemId = R.id.home
                            2 -> bottomNavigationView.selectedItemId = R.id.strat
                            3 -> bottomNavigationView.selectedItemId = R.id.tips
                            4 -> bottomNavigationView.selectedItemId = R.id.history
                        }
                    }
                })
            }

            bottomNavigationView.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.main -> setCurrentItem(0)
                    R.id.home -> setCurrentItem(1)
                    R.id.strat -> setCurrentItem(2)
                    R.id.tips -> setCurrentItem(3)
                    R.id.history -> setCurrentItem(4)
                }
                true
            }

        }
    }

    private fun hideBottomNav(b: Boolean) {
        binding.bottomNavigationView.visibility = if(b) View.GONE else View.VISIBLE
    }

    private fun setCurrentItem(i: Int) {
        binding.viewPager.currentItem = i
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onBackPressed() {
        if(binding.viewPager.currentItem > 0){
            binding.viewPager.currentItem = 0
        }else AlertDialog.Builder(this)
            .setTitle("Exit Application?")
            .setMessage("Do you want to exit?")
            .setPositiveButton("Ok"){ _,_ -> super.onBackPressed() }
            .setNegativeButton("Cancel"){ d, _ -> d.dismiss()}
            .show()
    }

    override fun onItemCLick(position: Int) {
        setCurrentItem(position)
    }

}