package com.guiller.prueba_tecnica.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.adapter.datosAdapater
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.api.retrofit
import com.guiller.prueba_tecnica.databinding.FragmentMaestroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.guiller.prueba_tecnica.inicio.InicioAppActivity.Companion.Getcadena

class MaestroFragment : Fragment() {
    private var _binding:FragmentMaestroBinding? = null
    private val binding  get() = _binding!!


    private var id: String? = null
    private var name: String? = null
    private var type:String? = null
    private var ppu: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecicle()
    }
    private fun initRecicle(){
        val cadenas = Getcadena()!!
        binding.rw1.layoutManager = LinearLayoutManager(context)
        binding.rw1.adapter = datosAdapater(cadenas){ Seleccionado(it) }

    }
    fun Seleccionado(datos: RespnseApiItem) {



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaestroBinding.inflate(inflater,container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_maestro, container, false)
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        private const val ARG_PARAM4 = "param4"


        @JvmStatic
        fun newInstance(id: String, name: String, type: String, ppu: String) =
            MaestroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, id)
                    putString(ARG_PARAM2, name)
                    putString(ARG_PARAM3, type)
                    putString(ARG_PARAM4, ppu)
                }
            }
    }
}