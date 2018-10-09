package com.mdm.lucidtimer.ui.ringer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mdm.lucidtimer.PhotosFragmentArgs
import com.mdm.lucidtimer.R
import com.mdm.lucidtimer.ui.ringer.RingerViewModel
import kotlinx.android.synthetic.main.fragment_photos.*
import kotlinx.android.synthetic.main.ringer_fragment.*

class RingerFragment : Fragment() {

    companion object {
        fun newInstance() = RingerFragment()
    }

//    private lateinit var viewModel: RingerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ringer_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ringerButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }

        arguments?.let {
            val safeArgs = PhotosFragmentArgs.fromBundle(it)
            textView_num.text = "Number of photos: ${safeArgs.numOfPhotos}"
        }
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(RingerViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}
