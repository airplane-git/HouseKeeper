package cn.feicui.com.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.view.textservice.TextInfo;

import org.w3c.dom.TypeInfo;

import java.io.File;
import java.util.ArrayList;

import cn.feicui.com.entity.TelclassInfo;
import cn.feicui.com.entity.TelnumberInfo;
import cn.feicui.com.main.TelmsgActivity;
import cn.feicui.com.utils.LogUtil;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
public class DBReader {

    public static File telFile;
    static {
        String dbFileDir = "data/data/cn.feicui.com/";
        File fileDir = new File(dbFileDir);
        fileDir.mkdirs();
        new File(dbFileDir,"commonnum.db");
        LogUtil.d("DBRead","telFile dir path"+dbFileDir);
    }

    public static boolean isExistsTeldbFile(){
        File toFile = DBReader.telFile;
        if (!toFile.exists()||toFile.length()<=0){
            return false;
        }
        return true;
    }
    public static ArrayList<TelclassInfo> readTeldbClasslist() throws Exception{
        int idx=0;
        ArrayList<TelclassInfo> classListInfos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = SQLiteDatabase.openOrCreateDatabase(telFile, null);
            cursor = db.rawQuery("select*from classlist", null);
            LogUtil.d("DBread", "read teldb classlist size:" + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    idx = cursor.getInt(cursor.getColumnIndex("idx"));
                    TelclassInfo classListInfo = new TelclassInfo(name, idx);
                    classListInfos.add(classListInfo);
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            throw e;
        }finally {
            try {
                cursor.close();
                db.close();
            }catch (Exception e2){
                throw e2;
            }
            LogUtil.d("DBRead","read teldb classlist end [list size]:"+classListInfos.size());
        }
        return classListInfos;
    }

    public static ArrayList<TelnumberInfo> readTeldbTable(int idx) throws Exception {
        ArrayList<TelnumberInfo> numberInfos = new ArrayList<>();
        String sql = "select * from table" + idx;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = SQLiteDatabase.openOrCreateDatabase(telFile, null);
            cursor = db.rawQuery(sql, null);
            LogUtil.d("DBRead", "read teldb number end size:" + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    TelnumberInfo numberInfo = new TelnumberInfo(name, number);
                    numberInfos.add(numberInfo);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cursor.close();
                db.close();
            } catch (Exception e2) {
                throw e2;
            }
            LogUtil.d("DBRead", "read teldb number table end [list size]:" + numberInfos.size());
        }
        return numberInfos;
    }
}
