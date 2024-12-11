package com.mobile.ficha7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", "$ 500,00", R.drawable.ic_launcher_foreground));
        products.add(new Product("Banana", "$ 20,00", R.drawable.ic_launcher_foreground));
        products.add(new Product("Orange", "$ 30,00", R.drawable.ic_launcher_foreground));
        products.add(new Product("Milk", "$ 40,00", R.drawable.ic_launcher_foreground));

        ProductAdapter adapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(adapter);
    }
}
