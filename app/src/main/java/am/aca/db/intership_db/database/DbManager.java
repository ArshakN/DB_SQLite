package am.aca.db.intership_db.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DbManager {
    private DatabaseHelper mDbHelper;

    public DbManager(Context context) {
        mDbHelper = new DatabaseHelper(context);
    }

    public long createUniversity() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(UniversityTable.COLUMN_NAME, "HPH");
        cv.put(UniversityTable.COLUMN_ADDRESS, "A. Manukyan");
        cv.put(UniversityTable.COLUMN_IS_NATIONAL, true);
        return db.insert(UniversityTable.TABLE_NAME, null, cv);
    }

    public void getUniversities(int minId, String namePrefix) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.query(UniversityTable.TABLE_NAME,
                null,
                UniversityTable.COLUMN_ID + "> ?" +
                        " AND " + UniversityTable.COLUMN_NAME + " = ?",
                new String[]{String.valueOf(minId), namePrefix},
                null, null,
                null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(UniversityTable.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(UniversityTable.COLUMN_NAME));
            String addres=cursor.getString(cursor.getColumnIndex(UniversityTable.COLUMN_ADDRESS));
            Log.d("SELECT", id + " : " + name + ", " + addres);
        }

        cursor.close();
    }
}
