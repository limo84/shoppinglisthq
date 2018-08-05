package de.programmierenlernenhq.shoppinglisthq;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ShoppingMemoDataSource {

    private static final String LOG_TAG = ShoppingMemoDataSource.class.getSimpleName();

    private SQLiteDatabase database;
    private ShoppingMemoDbHelper dbHelper;

    private String[] columns = {
            ShoppingMemoDbHelper.COLUMN_ID,
            ShoppingMemoDbHelper.COLUMN_PRODUCT,
            ShoppingMemoDbHelper.COLUMN_QUANTITY
    };
    

    public ShoppingMemoDataSource(Context context) {
        Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
        dbHelper = new ShoppingMemoDbHelper(context);
    }

    public void open() {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
    }
}