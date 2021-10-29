package android.example.test_shppingmall.fragment;

import android.content.Intent;
import android.example.test_shppingmall.Checkout_End;
import android.example.test_shppingmall.GoodsEntity;
import android.example.test_shppingmall.R;
import android.example.test_shppingmall.SQLiteDataBaseHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Fragment_shoppingcart extends Fragment implements View.OnClickListener {
    private static ArrayList<GoodsEntity> goodsEntityList_b = new ArrayList<GoodsEntity>();
    TextView shoppingcart_Order;
    Button shoppingcart_Endbtn;
    SQLiteDataBaseHelper mDBHelper;


    public Fragment_shoppingcart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        shoppingcart_Order = view.findViewById(R.id.shoppingcart_Order);
        shoppingcart_Endbtn = view.findViewById(R.id.shoppingcart_Endbtn);
        shoppingcart_Endbtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StringBuilder builder = new StringBuilder();

        for (GoodsEntity item : goodsEntityList_b) {
            builder.append("\n").append("name = ").append(item.goodsName).append("\n")
                    .append("price = ").append(item.goodsPrice).append("\n")
                    .append("number = ").append(item.goodsNumber).append("\n")
                    .append("resId = ").append(item.goodsImage).append("\n")
                    .append("url = ").append(item.goodsImage).append("\n")
                    .append("------------------------------------------------------------------------------------");
        }

        shoppingcart_Order.setText(builder.toString());
    }

    public static void addItem(GoodsEntity item) {
        goodsEntityList_b.add(item);
    }

    @Override
    public void onClick(View v) {
        for (GoodsEntity item : goodsEntityList_b) {
            String goodsName = item.getGoodsName();
            String goodsPrice = item.getGoodsPrice();
            String goodsNumber = item.getGoodsNumber();
            mDBHelper.addData(goodsName, goodsNumber, goodsPrice);
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), Checkout_End.class);
        startActivity(intent);

    }

}