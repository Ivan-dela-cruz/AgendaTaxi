package co.desofsi.taxiapp.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    final String TABLE_OWNERS_TAXIS = "CREATE TABLE IF NOT EXISTS owners_taxi(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, image BLOB, phone TEXT, email TEXT,movil TEXT)";
    final String TABLE_TAXIS = "CREATE TABLE IF NOT EXISTS taxis(id INTEGER PRIMARY KEY AUTOINCREMENT,description TEXT,model TEXT,imagen BLOB,price DOUBLE, id_owner INTEGER NOT NULL CONSTRAINT fk_id_owner_taxi REFERENCES owners_taxi(id) ON DELETE CASCADE ON UPDATE CASCADE)";

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    ////Funcion extraer datos

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }


    ///EJECUCIONES FUNCIONES ************************************************************

    ///INGRESO DE contactos de Taxistas

    public void insertDataContactos(String name,String tele,String movil, String email, byte[] image) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO owners_taxi VALUES(null,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, tele);
        statement.bindString(3, movil);
        statement.bindString(4, email);
        statement.bindBlob(5, image);
        statement.executeInsert();

    }



    ///INGRESO DE contactos de Taxistas

    public void insertDataTaxis(String descrip,String modelo, byte[] image, double precio, int id_taxi) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO owners_taxi VALUES(null,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, descrip);
        statement.bindString(2, modelo);
        statement.bindBlob(3, image);
        statement.bindDouble(4, precio);
        statement.bindDouble(5, id_taxi);
        statement.executeInsert();

    }




    ////    EXRAER DATOS DE LAS TABLAS
    public Cursor getDataTable(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_OWNERS_TAXIS);
        db.execSQL(TABLE_TAXIS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
