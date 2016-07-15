package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {
        if(quantity > 0) {
            quantity = quantity - 1;
        }
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name: " + name);

        CheckBox CreamCheckBox = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean hasCream = CreamCheckBox. isChecked();
        Log.v("MainActivity", "Has cream: " + hasCream);

        CheckBox SugarCheckBox = (CheckBox) findViewById(R.id.sugar_checkbox);
        boolean hasSugar = SugarCheckBox. isChecked();
        Log.v("MainActivity", "Has sugar: " + hasSugar);

        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCheckBox. isChecked();
        Log.v("MainActivity", "Has chocolate: " + hasChocolate);

        CheckBox CaramelCheckBox = (CheckBox) findViewById(R.id.caramel_checkbox);
        boolean hasCaramel = CaramelCheckBox. isChecked();
        Log.v("MainActivity", "Has caramel: " + hasCaramel);

        int price = calculatePrice(hasCream, hasSugar, hasChocolate, hasCaramel);

        String priceMessage = createOrderSummary(name, price, hasCream, hasSugar, hasChocolate, hasCaramel);
        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice(boolean addCream, boolean addSugar, boolean addChocolate, boolean addCaramel) {

        int basePrice = 5;
        if (addCream){
            basePrice = basePrice + 1;
        }

        if (addSugar){
            basePrice = basePrice + 1;
        }

        if (addChocolate){
            basePrice = basePrice + 2;
        }

        if (addCaramel){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }


    private String createOrderSummary(String name, int price, boolean addCream, boolean addSugar, boolean addChocolate, boolean addCaramel){
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Cream? " + addCream;
        priceMessage += "\nAdd Sugar? " + addSugar;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nAdd Caramel? " + addCaramel;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you and have a nice day!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}