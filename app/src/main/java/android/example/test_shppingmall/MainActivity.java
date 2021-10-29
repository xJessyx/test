package android.example.test_shppingmall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.test_shppingmall.fragment.Fragment_home;
import android.example.test_shppingmall.fragment.Fragment_member;
import android.example.test_shppingmall.fragment.Fragment_shoppingcart;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:  //我上一篇的menu裡面設的id
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Fragment_home()).commit();
                    //切換fragment
                    return true;
                case R.id.member:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Fragment_member()).commit();
                    return true;
                case R.id.shoppingcart:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Fragment_shoppingcart()).commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMain();
        BottomNavigationView navigation = findViewById(R.id.bottom_navigationview);
        Stetho.initializeWithDefaults(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    private void setMain() {  //這個副程式用來設置顯示剛進來的第一個主畫面

        this.getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new Fragment_home()).commit();
    }

}

