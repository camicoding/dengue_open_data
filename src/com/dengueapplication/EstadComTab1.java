package com.dengueapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link EstadComTab1.OnFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link EstadComTab1#newInstance} factory method to create an instance of this
 * fragment.
 * 
 */
public class EstadComTab1 extends Fragment {

	public EstadComTab1() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_estad_com_tab1, container, false);
	}
}
