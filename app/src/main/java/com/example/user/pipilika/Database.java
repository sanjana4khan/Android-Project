package com.example.user.pipilika;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by USER on 1/12/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Library.db";
    public static final String TABLE_NAME="AddBook";
    public static final String Col_1="BookId";
    public static final String Col_2="Book_Name";
    public static final String Col_3="Author";
    public static final String Col_4="Edition";
    public static final String TABLE_NAME2="Registration";
    public static final String name="name";


    public static final String semester="semester";
    public static final String year="year";
    public static final String user_name="user_name";
    public static final String password="password";



    public Database(Context context)  {
        super(context,DATABASE_NAME,null,1);
        //SQLiteDatabase database=this.getWritableDatabase();
    }

   /* public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL ("create table " + TABLE_NAME +"(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
               Col_2 + " TEXT," + Col_3 +" TEXT," + Col_4 + " TEXT" + ") ");
        database.execSQL("create table " + TABLE_NAME2 +"(" + name + " TEXT,"
                 + semester +" TEXT," + year + " TEXT," + user_name +" TEXT,"+ password +" TEXT" +") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
       database.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME );
        onCreate(database);
    }

  boolean insert_data( String book_name,String author,String edition)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        String insert = "insert into AddBook(Book_Name,Author,Edition) values('"+book_name+"','"+author+"','"+edition+"')";
        database.execSQL(insert);

        database.close();

            return true;
    }
    boolean insert_signup_data(String name,String semester,String year,String user_name,String password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String insert = "insert into Registration(name,semester,year,user_name,password) values('"+name+"','"+semester+"','"+year+"','"+user_name+"','"+password+"')";
        database.execSQL(insert);
        database.close();

        return true;

    }
    boolean delete(int id)
    {

        //Log.d("deleting id= ", String.valueOf(id));
        Log.d("deleting","deleting");

        SQLiteDatabase db=this.getWritableDatabase();
        String s = "delete from AddBook where BookId="+id;
        db.execSQL(s);
        //db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
        return true;
    }

  /*  public Cursor getCursor(){
        SQLiteDatabase db=this.getReadableDatabase();
        String selectquery="SELECT "+ Col_2 + ", " + Col_3 + ", " + Col_4 + " FROM "+ TABLE_NAME;
        return db.rawQuery(selectquery, null);
    }*/

    public List<Book_info> getAllBooks()
    {
        List<Book_info> book=new ArrayList<Book_info>();
        SQLiteDatabase db=this.getReadableDatabase();

        String selectquery="SELECT * FROM "+ TABLE_NAME ;
        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Book_info books= new Book_info(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                books.setId(Integer.parseInt(cursor.getString(0)));
                books.setBook_name(cursor.getString(1));
                books.setAuthor(cursor.getString(2));
                books.setEdition(cursor.getString(3));
                book.add(books);
            }while(cursor.moveToNext());
        }
        db.close();
        return book;
    }
    public Book_info getBook(String book)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        //String selectquery="select * from AddBook where Book_Name="+book;
        //Cursor cursor=db.rawQuery(selectquery, null);

       Cursor cursor = db.query(TABLE_NAME, new String[] {Col_1,Col_2,Col_3,Col_4}, Col_2+"=?",new String[]{book} ,null, null,null, null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        Book_info books= new Book_info(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        books.setId(Integer.parseInt(cursor.getString(0)));
        books.setBook_name(cursor.getString(1));
        books.setAuthor(cursor.getString(2));
        books.setEdition(cursor.getString(3));
        db.close();

        return books;
    }

    /*public String[] getAllAutherString()
    {
        //List<Book_info> book=new ArrayList<Book_info>();
        String str
        SQLiteDatabase db=this.getReadableDatabase();

        String selectquery="SELECT * FROM "+ TABLE_NAME;
        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Book_info books= new Book_info(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                books.setId(Integer.parseInt(cursor.getString(0)));
                books.setBook_name(cursor.getString(1));
                books.setAuthor(cursor.getString(2));
                books.setEdition(cursor.getString(3));
                book.add(books);
            }while(cursor.moveToNext());
        }
        db.close();
        return book;
    }*/

    public String login(String user_name)
    {
        SQLiteDatabase db=getReadableDatabase();
        String query="select user_name,password from "+TABLE_NAME2;
        Cursor cursor=db.rawQuery(query , null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);
                if(a.equals(user_name))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        db.close();
        return b;

    }
    public void deleteAll()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();

    }

}
