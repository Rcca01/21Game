package company.com.br.a21game

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dados_jogador.*

/**
 * Created by Opti9020-C2B on 2/7/2018.
 */

class DadosJogadorActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_jogador)

        iniciarJogo.setOnClickListener({
            startGame()
        })
    }

    fun startGame(){
        if(nomeJogador.text.isEmpty()){
            Toast.makeText(this,"Seu nome é necessário",Toast.LENGTH_SHORT).show();
        }else{
            val mainActivity = Intent(this,MainActivity::class.java)
            mainActivity.putExtra("NOMEJOGADOR",nomeJogador.text.toString())
            startActivity(mainActivity);
        }
    }
}