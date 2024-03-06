package com.guiller.prueba_tecnica.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.guiller.prueba_tecnica.adapter.datosAdapater
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.Topping
import com.guiller.prueba_tecnica.databinding.FragmentMaestroBinding
import com.guiller.prueba_tecnica.inicio.InicioAppActivity.Companion.getResponse
import com.guiller.prueba_tecnica.interfac.passDetalel

class MaestroFragment : Fragment() {
    private var _binding:FragmentMaestroBinding? = null
    private val binding  get() = _binding!!
    private lateinit var passDetalel:passDetalel





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecicle()

    }
    private fun initRecicle(){
        val cadenas = getResponse()
        binding.rw1.layoutManager = LinearLayoutManager(context)
        binding.rw1.adapter = datosAdapater(cadenas){ seleccionado(it.topping,it.batters.batter) }

    }

    private fun seleccionado(datos: List<Topping>, dataB:List<Batter>) {
        passDetalel = requireActivity() as passDetalel
        passDetalel.datoDetalle(datos,dataB)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaestroBinding.inflate(inflater,container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_maestro, container, false)
    }


}