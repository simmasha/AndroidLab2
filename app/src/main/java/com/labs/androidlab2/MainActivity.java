package com.labs.androidlab2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.labs.androidlab2.ShoppingListAdapter;

public class MainActivity extends AppCompatActivity {

    private ShoppingListAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.productList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        productAdapter = new ShoppingListAdapter(new ArrayList<>());
        recyclerView.setAdapter(productAdapter);

        super.onCreate(savedInstanceState);
    }

    public void save(View view) {
        EditText productNameEditText = findViewById(R.id.productName);
        String productName = productNameEditText.getText().toString();
        productNameEditText.setText("");

        EditText productNumberEditText = findViewById(R.id.productNumber);
        String productNumber = productNumberEditText.getText().toString();
        productNumberEditText.setText("");

        productAdapter.save(productName, productNumber);
    }

    public void clear(View view) {
        productAdapter.clearAll();
    }
}