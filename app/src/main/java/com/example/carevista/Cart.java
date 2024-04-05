package com.example.carevista;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Cart extends AppCompatActivity {
    double totalPrice = 0;
    String valueTotal1="";
TextView totalPriceTextView, finalCartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

            totalPriceTextView = findViewById(R.id.totalPriceTextView);
            finalCartItems=findViewById(R.id.finalCartItems);

            Intent intentk=getIntent();
            String cartnameitems="";
            cartnameitems=intentk.getStringExtra("name2");

            valueTotal1=intentk.getStringExtra("price2");

            if(valueTotal1!=null){
            double valueTotal2= Double.parseDouble(valueTotal1);
            totalPrice+=valueTotal2;}

            String str="You have added the items: "+cartnameitems+" ";
            finalCartItems.setText(str);
            totalPriceTextView.setText(String.valueOf(totalPrice));

    }
}
