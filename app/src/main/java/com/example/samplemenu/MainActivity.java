package com.example.samplemenu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner types;
    private Button show;
    private ListView drinks;
    private MockupDA da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        types = findViewById(R.id.drinkTypes);
        show = findViewById(R.id.show);
        drinks = findViewById(R.id.drinks);
        da = new MockupDA();

        bindSpinner();

        List<Drink> allDrink;
        allDrink = da.getAllDrinks();
        showDrinksList(allDrink);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedType = types.getSelectedItem().toString();
                List<Drink> drinkList;

                if (selectedType.equals("All Drinks")) {
                    drinkList = da.getAllDrinks();
                } else {
                    drinkList = da.getDrinkByType(selectedType);
                }

                showDrinksList(drinkList);
            }
        });
    }

    private void bindSpinner() {
        List<String> Dtypes = da.getDrinkTypes();
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Dtypes);
        types.setAdapter(spnAdapter);
    }

    private void showDrinksList(List<Drink> drinkList){
        List<String> displayList = new ArrayList<>();
        for (Drink drink : drinkList) {
            String displayString = drink.toString();
            displayList.add(displayString);
        }

        // Create an ArrayAdapter to display the list of drinks in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, displayList);
        drinks.setAdapter(adapter);

    }

}