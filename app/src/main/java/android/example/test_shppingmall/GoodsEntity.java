package android.example.test_shppingmall;

import android.example.test_shppingmall.fragment.Fragment_home;
import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class GoodsEntity implements Serializable {
    public String goodsNumber;//商品數量
    public String goodsName;//商品名稱
    public String goodsPrice;//商品價格
    public ImageView goodsImage;//商品圖片
    public int resId;
    public String url;

    public GoodsEntity() {
    }
    public GoodsEntity(String goodsNumber, String goodsName, String goodsPrice) {
        this.goodsNumber = goodsNumber;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsImage = goodsImage;

    }
    public String getGoodsNumber() {

        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {

        this.goodsNumber = goodsNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public ImageView getgoodsImage() {
        return goodsImage;
    }

    public void setgoodsImage(ImageView goodsImage) {
        this.goodsImage = goodsImage;
    }
    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goodsNumber='" + goodsNumber + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }


}
