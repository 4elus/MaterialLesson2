package ru.geekbrains.themechanger.kotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.geekbrains.themechanger.R
import ru.geekbrains.themechanger.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), View.OnClickListener {

    private lateinit var parentActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = (context as MainActivity)

        parentActivity = activity as MainActivity
        parentActivity =
            requireActivity() as MainActivity
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnThemeOne.setOnClickListener(this)
        binding.btnThemeSecond.setOnClickListener(this)

        when (parentActivity.getCurrentTheme()) {
            1 -> binding.radioGroup.check(R.id.btnThemeOne)
            2 -> binding.radioGroup.check(R.id.btnThemeSecond)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnThemeOne -> {
                parentActivity.setCurrentTheme(ThemeOne)
                parentActivity.recreate()
            }
            R.id.btnThemeSecond -> {
                parentActivity.setCurrentTheme(ThemeSecond)
                parentActivity.recreate()
            }
        }

    }

    companion object {
        fun newInstance() = FirstFragment()
    }


}