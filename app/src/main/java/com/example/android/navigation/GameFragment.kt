/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)
        val args = GameFragmentArgs.fromBundle(requireArguments())
        var Ran = args.randomNumber.toInt()
        var times = 0
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->

            times++
            var gessing = binding.yourgessing.text.toString()
            var g = gessing.toInt()

            if (times >= 10){
                view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
            }

            if (g > Ran){
                var gessingstring = "小於"+gessing
                binding.gessnumber.text = gessingstring
            }
            if(g < Ran && times<10){
                    var gessingstring = "大於"+gessing
                    binding.gessnumber.text = gessingstring
            }
            if(g == Ran){
                view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(times))
            }
            
        }


        return binding.root
    }


}


