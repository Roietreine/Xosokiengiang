package rej.ano.xsotngng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpType

class SplashActivity : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashAction(JumpType.JUMP_LINK, 3){ _, _ ->
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    startActivity(MainActivity.getStartIntent(this))
                    finish()
                },1500
            )
        }
    }
}