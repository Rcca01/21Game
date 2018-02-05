package company.com.br.a21game

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_estorou_pontuacao.*
import java.io.InputStream

/**
 * Created by Opti9020-C2B on 2/5/2018.
 */


class EstorouPontuacaoActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estorou_pontuacao)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        animation_view.setAnimation("emoji_tongue.json")
        animation_view.loop(true)
        animation_view.playAnimation()

        tvPontuacaoFinal.text = intent.getStringExtra("PONTUACAO")

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
