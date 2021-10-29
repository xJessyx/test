package android.example.test_shppingmall.fragment;

import android.example.test_shppingmall.CollectRecycleAdapter;
import android.example.test_shppingmall.GoodsEntity;
import android.icu.util.ValueIterator;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.example.test_shppingmall.R;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_home extends Fragment {
    private View view; //定義view用來設定fragment的layout
    public RecyclerView mCollectRecyclerView;//定義RecyclerView
    //定義以goodsentity實體類為物件的資料集合
    private ArrayList<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();
    //自定義recyclerveiw的介面卡
    private CollectRecycleAdapter mCollectRecyclerAdapter;
    public Fragment_home() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        //對recycleview進行配置
        initRecyclerView();
        //模擬資料
        initData();
        return view;

    }

    /**
     * TODO 模擬資料
     */

private void initData() {

            GoodsEntity goodsEntity1 = new GoodsEntity();
            goodsEntity1.setGoodsNumber("1531511");
            goodsEntity1.setGoodsName("波斯菊");
            goodsEntity1.setGoodsPrice("$100");
            goodsEntity1.url = "";
            goodsEntity1.resId = R.drawable.cosmos;
            goodsEntityList.add(goodsEntity1);

            GoodsEntity goodsEntity2 = new GoodsEntity();
            goodsEntity2.setGoodsNumber("223565");
            goodsEntity2.setGoodsName("綜合鬱金香");
            goodsEntity2.setGoodsPrice("$50");
            goodsEntity2.url = "";
            goodsEntity2.resId = R.drawable.synthetictulip;
            goodsEntityList.add(goodsEntity2);

            GoodsEntity goodsEntity3 = new GoodsEntity();
            goodsEntity3.setGoodsNumber("486143");
            goodsEntity3.setGoodsName("綜合繡球花");
            goodsEntity3.setGoodsPrice("$35");
            goodsEntity3.url = "";
            goodsEntity3.resId = R.drawable.hydrangea;
            goodsEntityList.add(goodsEntity3);

            GoodsEntity goodsEntity4 = new GoodsEntity();
            goodsEntity4.setGoodsNumber("123588");
            goodsEntity4.setGoodsName("綜合桔梗");
            goodsEntity4.setGoodsPrice("$60");
            goodsEntity4.url = "";
            goodsEntity4.resId = R.drawable.lisianthusflower;
            goodsEntityList.add(goodsEntity4);

            GoodsEntity goodsEntity5 = new GoodsEntity();
            goodsEntity5.setGoodsNumber("123588");
            goodsEntity5.setGoodsName("多重桔梗");
            goodsEntity5.setGoodsPrice("$150");
            goodsEntity5.url = "";
            goodsEntity5.resId = R.drawable.multipleplatycodons;
            goodsEntityList.add(goodsEntity5);

            GoodsEntity goodsEntity6 = new GoodsEntity();
            goodsEntity6.setGoodsNumber("123581");
            goodsEntity6.setGoodsName("藍繡球花");
            goodsEntity6.setGoodsPrice("$100");
            goodsEntity6.url = "";
            goodsEntity6.resId = R.drawable.orchidflower;
            goodsEntityList.add(goodsEntity6);

            GoodsEntity goodsEntity7 = new GoodsEntity();
            goodsEntity7.setGoodsNumber("145555");
            goodsEntity7.setGoodsName("玫瑰花");
            goodsEntity7.setGoodsPrice("$120");
            goodsEntity7.url = "";
            goodsEntity7.resId = R.drawable.roseflower;
            goodsEntityList.add(goodsEntity7);

            GoodsEntity goodsEntity8 = new GoodsEntity();
            goodsEntity8.setGoodsNumber("858666");
            goodsEntity8.setGoodsName("紅鬱金香");
            goodsEntity8.setGoodsPrice("$190");
            goodsEntity8.url = "";
            goodsEntity8.resId = R.drawable.tulip;
            goodsEntityList.add(goodsEntity8);
//    for (int i = 0; i < 100; i++) {
//        GoodsEntity goodsEntity = new GoodsEntity();
//        goodsEntity.setgoodsNumber("number"+i);
//        goodsEntity.setGoodsName("a" + i);
//        goodsEntity.setGoodsPrice("100" + i);
//        goodsEntity.url = "";
//        goodsEntity.resId = R.drawable.ic_baseline_home_24;
//        goodsEntityList.add(goodsEntity);
//    }
}



        /**
         * TODO 對recycleview進行配置
         */
        private void initRecyclerView () {
            //獲取RecyclerView
            mCollectRecyclerView = (RecyclerView) view.findViewById(R.id.collect_recyclerView);
            //建立adapter
            mCollectRecyclerAdapter = new CollectRecycleAdapter(getActivity(), goodsEntityList);
            //給RecyclerView設定adapter
            mCollectRecyclerView.setAdapter(mCollectRecyclerAdapter);
            //設定layoutManager,可以設定顯示效果，是線性佈局、grid佈局，還是瀑布流佈局
            //引數是：上下文、列表方向（橫向還是縱向）、是否倒敘
//            mCollectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2,RecyclerView.VERTICAL, false);
            mCollectRecyclerView.setLayoutManager(mLayoutManager );
            mCollectRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
            //RecyclerView中沒有item的監聽事件，需要自己在介面卡中寫一個監聽事件的介面。引數根據自定義
            mCollectRecyclerAdapter.setOnItemClickListener(new CollectRecycleAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(View view, GoodsEntity data) {
                    //此處進行監聽事件的業務處理
                    Toast.makeText(getActivity(), "加入 "+data.goodsName+" 到購物車", Toast.LENGTH_SHORT).show();
                    Fragment_shoppingcart.addItem(data);
                }
            });
        }

}