package am.aca.db.intership_db.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UniversityTable.CREATE_SCRIPT);
        db.execSQL("CREATE TABLE student " +
                "(" +
                "id INTEGER PRIMARY KEY," +
                "fullname TEXT NOT NULL," +
                "age INTEGER" +
                ")");

        Log.d("DB", "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UniversityTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS students");

        db.execSQL(UniversityTable.CREATE_SCRIPT);
        db.execSQL("CREATE TABLE student " +
                "(" +
                "id INTEGER PRIMARY KEY," +
                "fullname TEXT NOT NULL," +
                "age INTEGER" +
                ")");
        Log.d("DB", "onUpgrade");
    }
}
