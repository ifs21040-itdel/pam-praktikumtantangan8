package com.ifs21040.tantanganprak8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ifs21040.tantanganprak8.databinding.FragmentDashboardBinding
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sFRagmentDashboard.setupWithSearchBar(sbFragmentDashboard)
            sFRagmentDashboard
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    sbFragmentDashboard.setText(sFRagmentDashboard.text)
                    sFRagmentDashboard.hide()

                    val message =
                        "Kamu mencari dengan keywords:\n${sFRagmentDashboard.text}"

                    Toast.makeText(
                        requireContext(),
                        message,
                        Toast.LENGTH_LONG
                    ).show()
                    false
                }
        }
    }
}
