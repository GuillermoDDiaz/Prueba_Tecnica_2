package com.guiller.prueba_tecnica.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.databinding.FragmentMaestroBinding


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
            id =  it.getString(ARG_PARAM1)
            name = it.getString(ARG_PARAM2)
            type = it.getString(ARG_PARAM3)
            ppu = it.getString(ARG_PARAM4)

        }



    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.txtIdF.text = id.toString()
        binding.txtNameF.text = name.toString()
        binding.txtTypeF.text = type.toString()
        binding.txtPpuF.text = ppu.toString()
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