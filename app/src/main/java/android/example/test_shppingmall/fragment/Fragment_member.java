package android.example.test_shppingmall.fragment;

import android.content.Intent;
import android.example.test_shppingmall.MainActivity;
import android.example.test_shppingmall.MemberInformation;
import android.example.test_shppingmall.Register;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.example.test_shppingmall.R;
import android.widget.Button;

public class Fragment_member extends Fragment implements View.OnClickListener {
    Button btn_register;
    Button btn_login;

    public Fragment_member() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_member, container, false);
        btn_login = view.findViewById(R.id.login);
        btn_register = view.findViewById(R.id.register);
        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), Register.class);
                startActivity(intent1);
                break;
            case R.id.login:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), MemberInformation.class);
                startActivity(intent2);
                break;
        }


    }
}