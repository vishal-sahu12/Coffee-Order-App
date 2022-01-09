package com.example.dukaan;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    public static int numberOfCoffees=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @submitOrder is called when the order button is clicked
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity","The Price is "+hasWhippedCream);

        CheckBox chocolateBox =(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateBox.isChecked();
        EditText nameText = (EditText) findViewById(R.id.name_text_view);
        String name = nameText.getText().toString();


        displayMessage(createOrderSummary(hasWhippedCream,hasChocolate,name));


      //** display(numberOfCoffees);
       // displayPrice(numberOfCoffees*5);
    }
    /*
    * This Method will execute when + button in clicked
    * */
    public void increment(View view){
        /*if(numberOfCoffees>=1 && numberOfCoffees<99){
        numberOfCoffees=numberOfCoffees+1;
        display(numberOfCoffees);}
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "You Cannot Have More than 99 Coffee", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }*/
        // Alternate Way For Increment
        if (numberOfCoffees ==99)
        {
            // Show Toast message
            Toast.makeText(this,"You Cannot Have More than 99 Coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees += 1;
        display(numberOfCoffees);
    }
    //This Method will execute when - button in clicked
    public void decrement(View view){
       /* if(numberOfCoffees>1 && numberOfCoffees<=99){
        numberOfCoffees=numberOfCoffees-1;
        display(numberOfCoffees);}
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "You Cannot Have Less than 1 Coffee", Toast.LENGTH_SHORT);
            toast.show();
        }
        */

        // Alternate Way For Decrement
        if (numberOfCoffees == 1){
            //show toast message
            Toast.makeText(this,"You Cannot Have Less than 1 Coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees-=1;
        display(numberOfCoffees);


    }
    /*
    * @param name = User Input Name
    * @whippedCream = return True/False for whippedCream CheckBox
    * */
    private String createOrderSummary(boolean whippedCream,boolean chocalte,String names) {
        if (numberOfCoffees >= 1 && numberOfCoffees <=99) {
            String Summary = "Name :" + names;
            Summary += "\nWhipp Cream :- " + whippedCream;
            Summary += "\nChocolate :- " + chocalte;
            Summary = Summary + "\nQuantity : " + numberOfCoffees;
            Summary += "\nTotal :" + calculatePrice(whippedCream, chocalte);
            Summary += "\nThank You";
            return Summary;
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Your Order Is Not Correct", Toast.LENGTH_SHORT);
            toast.show();
            return "Your Order Is Not Correct\nPlease Review Your Order";
        }
    }




    /*
    * It is A method used for calculate the Total Price Of Coffess
    * /`/*/
    private int calculatePrice(boolean whippCream, boolean chocolate){
        int price = 5;
        if(whippCream){
            price = price +1;}
        if (chocolate) {
            price = price + 2;
        }
        return price *numberOfCoffees;}


        /* Alternate Ways to do with
        *int price =numberOfCoffees;
        if (whippCream==true && chocolate == true){
            price = price * (5+1+2);
            return  price;
        }
        else if(whippCream==true||chocolate ==false){
            price =price *(5+1);
            return price;
        }
        else if(whippCream==false|| chocolate==true){
            price =price *(5+2);
            return price;
        }
        else{
            return price*5;*/

    /*private void displayPrice(int number)
    {
        TextView priceTextView =(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    /**
     * This method displays the given quantity value on the screen.
     */
    private void
    display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String message){
        TextView orderSummaryTextView= (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}