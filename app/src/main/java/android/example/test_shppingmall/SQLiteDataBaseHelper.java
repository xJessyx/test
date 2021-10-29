package android.example.test_shppingmall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
    String TAG = SQLiteDataBaseHelper.class.getSimpleName();
    String TableName;




    public SQLiteDataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version,String TableName) {
        super(context, name, factory, version);
        this.TableName = TableName;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLTable = "CREATE TABLE IF NOT EXISTS" + TableName + "(" +
               "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
               "Name TEXT, " +
                "Number INTEGER, " +
                "Price INTEG@ER" +");";
        db.execSQL(SQLTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TableName;
        db.execSQL(SQL);
    }
    //檢查資料表狀態，若無指定資料表則新增
    public void chickTable(){
        Cursor cursor = getWritableDatabase().rawQuery(
                "select DISTINCT tbl_name from sqlite_master where tbl_name = '" + TableName + "'", null);
        if (cursor != null) {
            if (cursor.getCount() == 0)
                getWritableDatabase().execSQL("CREATE TABLE IF NOT EXISTS " + TableName + "( " +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT, " +
                        "Number INTEGER, " +
                        "Price INTEGER" +
                        ");");
            cursor.close();
        }
    }

    //取得有多少資料表,並以陣列回傳
    public ArrayList<String> getTables(){
        Cursor cursor = getWritableDatabase().rawQuery(
                "select DISTINCT tbl_name from sqlite_master", null);
        ArrayList<String> tables = new ArrayList<>();
        while (cursor.moveToNext()){
            String getTab = new String (cursor.getBlob(0));
            if (getTab.contains("android_metadata")){}
            else if (getTab.contains("sqlite_sequence")){}
            else tables.add(getTab.substring(0,getTab.length()-1));

        }
        return tables;
    }
    //新增資料
    public void  addData(String name, String number, String price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Number", number);
        values.put("Price", price);
        db.insert(TableName, null, values);
    }

    //顯示所有資料
    public ArrayList<HashMap<String, String>> showAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + TableName, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            String id = c.getString(0);
            String name = c.getString(1);
            Integer number = c.getInt(2);
            Integer price = c.getInt(3);

            hashMap.put("id", id);
            hashMap.put("name", name);
            hashMap.put("number", String.valueOf(number));
            hashMap.put("price", String.valueOf(price));
            arrayList.add(hashMap);
        }
        return arrayList;

    }
//    //以id搜尋特定資料
//    public ArrayList<HashMap<String,String>> searchById(String getId){
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c = db.rawQuery(" SELECT * FROM " + TableName
//                + " WHERE _id =" + "'" + getId + "'", null);
//        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
//        while (c.moveToNext()) {
//            HashMap<String, String> hashMap = new HashMap<>();
//
//            String id = c.getString(0);
//            String name = c.getString(1);
//            String number = c.getString(2);
//            String price = c.getString(3);
//
//            hashMap.put("id", id);
//            hashMap.put("name", name);
//            hashMap.put("number", number);
//            hashMap.put("price", price);
//            arrayList.add(hashMap);
//        }
//        return arrayList;
//    }
//
//    //以興趣篩選資料
//    public ArrayList<HashMap<String, String>> searchByHobby(String getName) {
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c = db.rawQuery(" SELECT * FROM " + TableName
//                + " WHERE name =" + "'" + getName + "'", null);
//        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
//        while (c.moveToNext()) {
//            HashMap<String, String> hashMap = new HashMap<>();
//
//            String id = c.getString(0);
//            String name = c.getString(1);
//            String number = c.getString(2);
//            String price = c.getString(3);
//
//            hashMap.put("id", id);
//            hashMap.put("name", name);
//            hashMap.put("number", number);
//            hashMap.put("price", price);
//            arrayList.add(hashMap);
//        }
//        return arrayList;
//    }
//
//    //修改資料(麻煩)
//    public void modify(String id, String name, String number, String price) {
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL(" UPDATE " + TableName
//                + " SET Name=" + "'" + name + "',"
//                + "number=" + "'" + number + "',"
//                + "price=" + "'" + price + "'"
//                + " WHERE _id=" + "'" + id + "'");
//    }
//
//    //修改資料(簡單)
//    public void modifyEZ(String id, String name, String number, String price) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("Name", name);
//        values.put("Number", number);
//        values.put("Price", price);
//        db.update(TableName, values, "_id = " + id, null);
//    }
//    //刪除全部資料
//    public void deleteAll(){
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("DELETE FROM"+TableName);
//    }
    //以id刪除資料(簡單)
    public void deleteByIdEZ(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TableName,"_id = " + id,null);
    }


}
