package company.com.br.a21game.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import company.com.br.a21game.EstorouPontuacaoActivity

import company.com.br.a21game.R
import company.com.br.a21game.dao.CartaDAO
import company.com.br.a21game.model.Carta
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    var gerador = Random()
    var cartas:MutableList<Carta> = ArrayList()
    val cartaDAO = CartaDAO()

    lateinit var btnRecomecar:Button
    lateinit var tvPontuacao:TextView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnProximaCarta.setOnClickListener({
            realizarJogada()
        })
    }

    override fun onCreateView(inflater: LayoutInflater?,container: ViewGroup?,savedInstanceState: Bundle?):View?{
        val view = inflater!!.inflate(R.layout.fragment_game,container,false)

        btnRecomecar = view.findViewById(R.id.btnRecomecar)
        tvPontuacao = view.findViewById(R.id.tvPontuacao)

        btnRecomecar.setOnClickListener({
            iniciarPartida()
        })
        iniciarPartida()
        return view
    }


    fun iniciarPartida(){
        tvPontuacao.setText("0")
        cartas = cartaDAO.getBaralho().toMutableList()
    }

    fun realizarJogada(){
        val posicaoCartaSelecionada = gerador.nextInt(cartas.size)
        val cartaSelecionada = cartas.get(posicaoCartaSelecionada)

        val pontuacaoAtualizada = tvPontuacao.text.toString().toInt() + cartaSelecionada.pontuacao
        tvPontuacao.text = pontuacaoAtualizada.toString()

        if(pontuacaoAtualizada > 21){
            val intent = Intent(context, EstorouPontuacaoActivity::class.java)
            intent.putExtra("PONTUACAO",tvPontuacao.text.toString())
            startActivity(intent)
        }else{
            cartas.removeAt(posicaoCartaSelecionada)
            ivCarta.setImageDrawable(ContextCompat.getDrawable(context,cartaSelecionada.resourceId))
        }
    }

}// Required empty public constructor
