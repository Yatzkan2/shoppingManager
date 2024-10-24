package com.example.shoppingmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {

    private EditText addProductName;
    private EditText addProductPrice;
    private EditText addProductAmount;
    private Button addProductButton;
    private RecyclerView productsRecyclerView;

    private ProductAdapter productAdapter;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // Initialize views
        addProductName = findViewById(R.id.add_product_name);
        addProductPrice = findViewById(R.id.add_product_price);
        addProductAmount = findViewById(R.id.add_product_amount);
        addProductButton = findViewById(R.id.add_product_button);
        productsRecyclerView = findViewById(R.id.products_recycler_view);

        // Initialize product list and adapter
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList, this);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productsRecyclerView.setAdapter(productAdapter);

        // Set button click listener
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });
    }

    private void addProduct() {
        String name = addProductName.getText().toString().trim();
        String priceString = addProductPrice.getText().toString().trim();
        String amountString = addProductAmount.getText().toString().trim();

        // Validate inputs
        if (name.isEmpty() || priceString.isEmpty() || amountString.isEmpty()) {
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        double price;
        int amount;

        try {
            price = Double.parseDouble(priceString);
            amount = Integer.parseInt(amountString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid price or amount!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create new product
        Product product = new Product(name, price, amount);
        productList.add(product);
        productAdapter.notifyItemInserted(productList.size() - 1);

        // Clear input fields
        addProductName.setText("");
        addProductPrice.setText("");
        addProductAmount.setText("");

        Toast.makeText(this, "Product added!", Toast.LENGTH_SHORT).show();
    }
}
