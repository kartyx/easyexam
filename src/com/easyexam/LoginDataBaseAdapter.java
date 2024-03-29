package com.easyexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
 
public class LoginDataBaseAdapter 
{
        static final String DATABASE_NAME = "login.db";
        static final int DATABASE_VERSION = 1;
        public static final int NAME_COLUMN = 1;
        // TODO: Create public field for each column in your table.
        // SQL Statement to create a new database.
        static final String DATABASE_CREATE = "create table "+"LOGIN"+
                                     "( " +"ID"+" integer primary key autoincrement,"+ "NAME text,USERNAME  text,PASSWORD text,CATEGORY text); ";
        // Variable to hold the database instance
        public  SQLiteDatabase db;
        // Context of the application using the database.
        private final Context context;
        // Database open/upgrade helper
        private DataBaseHelper dbHelper;
        public  LoginDataBaseAdapter(Context _context) 
        {
            context = _context;
            dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public  LoginDataBaseAdapter open() throws SQLException 
        {
            db = dbHelper.getWritableDatabase();
            return this;
        }
        public void close() 
        {
            db.close();
        }
 
        public  SQLiteDatabase getDatabaseInstance()
        {
            return db;
        }
 
        public void insertEntry(String Name,String userName,String password,String category)
        {
           ContentValues newValues = new ContentValues();
            // Assign values for each row.
            newValues.put("NAME", Name);
            newValues.put("USERNAME", userName);
            newValues.put("PASSWORD",password);
            newValues.put("CATEGORY", category);
            // Insert the row into your table
            db.insert("LOGIN", null, newValues);
            ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
        }
        public int deleteEntry(String UserName)
        {
            //String id=String.valueOf(ID);
            String where="USERNAME=?";
            int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
            //Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
            return numberOFEntriesDeleted;
        }    
        public String getSinlgeEntry(String userName)
        {
            Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
            if(cursor.getCount()<1) // UserName Not Exist
            {
                cursor.close();
                return "NOT EXIST";
            }
            cursor.moveToFirst();
            String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
            cursor.close();
            return password;                
        }
        public String getCategory(String userName)
        {
            Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
            if(cursor.getCount()<1) // UserName Not Exist
            {
                cursor.close();
                return "NOT EXIST";
            }
            cursor.moveToFirst();
            String category=cursor.getString(cursor.getColumnIndex("CATEGORY"));
            cursor.close();
            return category;
        }
        public void  updateEntry(String Name,String userName,String password,String category)
        {
            ContentValues updatedValues = new ContentValues();
            updatedValues.put("NAME", Name);
            updatedValues.put("USERNAME", userName);
            updatedValues.put("PASSWORD",password);
            updatedValues.put("CATEGORY", category);
            String where="USERNAME = ?";
                    }        
}