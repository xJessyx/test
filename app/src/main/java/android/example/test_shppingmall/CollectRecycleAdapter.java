package android.example.test_shppingmall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CollectRecycleAdapter extends RecyclerView.Adapter<CollectRecycleAdapter.myViewHodler> {
    private Context context;
    private ArrayList<GoodsEntity> goodsEntityList;

    //建立建構函式
    public CollectRecycleAdapter(Context context, ArrayList<GoodsEntity> goodsEntityList) {
        //將傳遞過來的資料，賦值給本地變數
        this.context = context;//上下文
        this.goodsEntityList = goodsEntityList;//實體類資料ArrayList
    }

    /**
     * 建立viewhodler，相當於listview中getview中的建立view和viewhodler
     *
     * @param parent
     * @param viewType
     * @return
     */

    @NonNull
    @Override
    public myViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_layout, null);
        return new myViewHodler(itemView);
    }

    /**
     * 繫結資料，資料與view繫結
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CollectRecycleAdapter.myViewHodler holder, int position) {
        //根據點選位置繫結資料
        GoodsEntity data = goodsEntityList.get(position);

//        holder.mItemGoodsImg.setImageResource(data.goodsImage);
        holder.mItemGoodsImg.setImageResource(data.resId);//獲取實體類中的image_ID欄位並設定
        holder.mItemGoodsNumber.setText(data.goodsNumber);//獲取實體類中的number欄位並設定
        holder.mItemGoodsName.setText(data.goodsName);//獲取實體類中的name欄位並設定
        holder.mItemGoodsPrice.setText(data.goodsPrice);//獲取實體類中的price欄位並設定
    }

    /**
     * 得到總條數
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return goodsEntityList.size();
    }

    //自定義viewhodler
    class myViewHodler extends RecyclerView.ViewHolder {
        private ImageView mItemGoodsImg;
        private TextView mItemGoodsName;
        private TextView mItemGoodsPrice;
        private TextView mItemGoodsNumber;

        public myViewHodler(View itemView) {
            super(itemView);
            mItemGoodsNumber = (TextView) itemView.findViewById(R.id.item_goods_number);
            mItemGoodsImg = (ImageView) itemView.findViewById(R.id.item_goods_img);
            mItemGoodsName = (TextView) itemView.findViewById(R.id.item_goods_name);
            mItemGoodsPrice = (TextView) itemView.findViewById(R.id.item_goods_price);

            //點選事件放在adapter中使用，也可以寫個介面在activity中呼叫
            //方法一：在adapter中設定點選事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以選擇直接在本位置直接寫業務處理
                    //Toast.makeText(context,"點選了xxx",Toast.LENGTH_SHORT).show();
                    //此處回傳點選監聽事件
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v, goodsEntityList.get(getLayoutPosition()));

                    }
                }
            });

        }
    }

    /**
     * 設定item的監聽事件的介面
     */
    public interface OnItemClickListener {
        /**
         * 介面中的點選每一項的實現方法，引數自己定義
         *
         * @param view 點選的item的檢視
         * @param data 點選的item的資料
         */
        public void OnItemClick(View view, GoodsEntity data);
    }

    //需要外部訪問，所以需要設定set方法，方便呼叫
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}