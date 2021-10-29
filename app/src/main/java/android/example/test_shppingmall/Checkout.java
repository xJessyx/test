package android.example.test_shppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Checkout extends AppCompatActivity implements View.OnClickListener {
    Button Checkout_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Checkout_btn= findViewById(R.id.Checkout_btn);
        Checkout_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(Checkout.this,Checkout_End.class);

    }
}