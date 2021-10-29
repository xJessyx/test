package android.example.test_shppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.example.test_shppingmall.fragment.Fragment_member;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button RegisterMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterMember= findViewById(R.id.RegisterMember);
        RegisterMember.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(Register.this, Fragment_member.class);
        startActivity(intent);

    }
}