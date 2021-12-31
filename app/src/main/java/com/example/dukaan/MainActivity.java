package com.example.dukaan;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    public static int numberOfCoffees=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String message ="Total = ₹" + numberOfCoffees*5;
        message = message +"\nThank You.";
        displayMessage(message);
      //** display(numberOfCoffees);
       // displayPrice(numberOfCoffees*5);
    }
    public void increment(View view){
        numberOfCoffees=numberOfCoffees+1;
        display(numberOfCoffees);
    }

    public void decrement(View view){
        numberOfCoffees=numberOfCoffees-1;
        display(numberOfCoffees);
    }
    private void displayPrice(int number)
    {
        TextView priceTextView =(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void
    display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String message){
        TextView priceTextView= (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}