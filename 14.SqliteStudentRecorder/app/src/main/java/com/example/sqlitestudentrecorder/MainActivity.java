package com.example.sqlitestudentrecorder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText editTextID, editTextName, editTextEmail, editTextCC;
    Button buttonAdd, buttonGetData, buttonDelete, buttonUpdate, buttonViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        editTextID = findViewById(R.id.editText_id);
        editTextName = findViewById(R.id.editText_name);
        editTextEmail = findViewById(R.id.editText_email);
        editTextCC = findViewById(R.id.editText_CC);

        buttonAdd = findViewById(R.id.button_add);
        buttonGetData = findViewById(R.id.button_view);
        buttonDelete = findViewById(R.id.button_delete);
        buttonViewAll = findViewById(R.id.button_viewAll);
        buttonUpdate = findViewById(R.id.button_update);

        addData();
        getData();
        viewAll();
        updateData();
        deleteData();
    }

    private void addData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(
                        editTextName.getText().toString(), editTextName.getText().toString(), editTextName.getText().toString());
                if (isInserted) {
                    Toast.makeText(getApplicationContext(),"Successfully Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Failed to insert data.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getData(){
        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString();

                if(id.equals(String.valueOf(""))){
                    editTextID.setError("Enter Id");
                }

                Cursor cursor = myDb.getData(id);
                String data = "";

                if (cursor.moveToNext()) {
                    data = "Name : " + cursor.getString(1) + "\n" +
                            "Email : " + cursor.getString(2) + "\n" +
                            "Courses : " + cursor.getString(3) + "\n";
                }

                showMessage("Data", data);
            }
        });


    }

    private void viewAll() {
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDb.getAllData();

                if (cursor.getCount() == 0){
                    Toast.makeText(getApplicationContext(), "Empty Database", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder buffer  = new StringBuilder();

                while(cursor.moveToNext()) {
                    buffer.append("ID : ").append(cursor.getString(0)).append("\n");
                    buffer.append("Name : ").append(cursor.getString(1)).append("\n");
                    buffer.append("Email : ").append(cursor.getString(2)).append("\n");
                    buffer.append("Courses Count : ").append(cursor.getString(2)).append("\n");
                    buffer.append("_____________").append("\n\n");
                }

                showMessage("All Data", buffer.toString());
            }
        });
    }

    private void updateData() {
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextID.getText().toString().equals(String.valueOf(""))) {
                    showMessage("Alert", "Id cannot be empty.");
                    return;
                }

                boolean isUpdated = myDb.updateData(editTextID.getText().toString(),
                        editTextName.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextCC.getText().toString()
                );

                if (isUpdated){
                    Toast.makeText(MainActivity.this, "Updated Successfully",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Something went wrong.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void deleteData(){
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString();

                if (id.equals(String.valueOf(""))){
                    editTextID.setError("Enter id");
                    return;
                }

                int rowsAffected = myDb.deleteData(id);

                if (rowsAffected < 0) {
                    Toast.makeText(MainActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No data deleted.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showMessage(String title, String message){
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
        aBuilder.create();
        aBuilder.setCancelable(true);
        aBuilder.setTitle(title);
        aBuilder.setMessage(message);
        aBuilder.show();
    }

}