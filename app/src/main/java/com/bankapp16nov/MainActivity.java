package com.bankapp16nov;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bankapp16nov.models.TypeCompte;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText soldeInput;
    private Spinner typeSpinner;
    private LinearLayout compteContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soldeInput = findViewById(R.id.soldeInput);
        typeSpinner = findViewById(R.id.typeSpinner);
        Button createButton = findViewById(R.id.createButton);
        compteContainer = findViewById(R.id.compteContainer);

        initializeTypeSpinner();

        createButton.setOnClickListener(v -> {
            String soldeText = soldeInput.getText().toString();
            String selectedType = typeSpinner.getSelectedItem().toString();

            if (soldeText.isEmpty()) {
                Toast.makeText(this, "Please enter solde", Toast.LENGTH_SHORT).show();
            } else {
                double solde = Double.parseDouble(soldeText);
                addCompteView(selectedType, solde);
                soldeInput.setText("");
            }
        });
    }

    private void initializeTypeSpinner() {
        ArrayList<String> types = new ArrayList<>();
        for (TypeCompte type : TypeCompte.values()) {
            types.add(type.name());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);
    }

    private void addCompteView(String type, double solde) {
        LinearLayout compteLayout = new LinearLayout(this);
        compteLayout.setOrientation(LinearLayout.HORIZONTAL);
        compteLayout.setPadding(8, 8, 8, 8);
        compteLayout.setBackgroundColor(Color.parseColor("#EFEFEF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 8, 0, 8);
        compteLayout.setLayoutParams(layoutParams);

        TextView compteInfo = new TextView(this);
        compteInfo.setText(type + ": " + solde);
        LinearLayout.LayoutParams infoParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        compteInfo.setLayoutParams(infoParams);

        Button editButton = new Button(this);
        editButton.setText("Edit");
        editButton.setOnClickListener(v -> {
            soldeInput.setText(String.valueOf(solde));
            typeSpinner.setSelection(((ArrayAdapter<String>) typeSpinner.getAdapter()).getPosition(type));
            compteContainer.removeView(compteLayout);
        });

        Button deleteButton = new Button(this);
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(v -> {
            compteContainer.removeView(compteLayout);
            Toast.makeText(this, "Compte deleted", Toast.LENGTH_SHORT).show();
        });

        compteLayout.addView(compteInfo);
        compteLayout.addView(editButton);
        compteLayout.addView(deleteButton);

        compteContainer.addView(compteLayout);
    }


}
