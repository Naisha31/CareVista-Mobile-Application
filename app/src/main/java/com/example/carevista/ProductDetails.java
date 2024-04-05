package com.example.carevista;

import androidx.appcompat.app.AppCompatActivity;
import com.example.carevista.CartItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class ProductDetails extends AppCompatActivity {

    ImageView img, back, imageView7;
    TextView proName, proPrice, proDesc, proQty, proUnit;

    String name2, price2, desc, qty, unit;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        name2 = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.dolo);
        price2 = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");

        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);
        proQty = findViewById(R.id.qty);
        proUnit = findViewById(R.id.unit);

        proName.setText(name2);
        proPrice.setText(price2);
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);

        img.setImageResource(image);
        imageView7 = findViewById(R.id.imageView7);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, Pharmacy.class);
                startActivity(i);
                finish();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetails.this, name2+" added to cart", Toast.LENGTH_SHORT).show();
                // Add the current product to the cart
                Intent intentk = new Intent(ProductDetails.this, Cart.class);
                intentk.putExtra("name2", name2);
                intentk.putExtra("price2", price2);
                startActivity(intentk);

            }
        });

    }
//    private void addToCart(String name, String price) {
//        int quantity = 1;
//
//        // Create a new CartItem
//        CartItem cartItem = new CartItem(name, Double.parseDouble(price), quantity);
//
//        // Get the current cart items list
//        List<CartItem> cartItems = Cart.getYourCartItems();
//
//        // Add the new item to the cart list
//        cartItems.add(cartItem);
//
//        // Navigate to CartActivity to display the cart contents
//        Intent intent = new Intent(ProductDetails.this, Cart.class);
//        startActivity(intent);
//
//        // Show a toast message to indicate that the item has been added to the cart
//        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
////        intent.putExtra("name", name);
////        intent.putExtra("price", price);
////        intent.putExtra("quantity", quantity);
//
//    }

}

