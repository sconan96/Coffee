package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox. isChecked();
        Log.v("MainActivity", "Has whipped cream: " + hasWhippedCream);

        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCheckBox. isChecked();
        Log.v("MainActivity", "Has chocolate: " + hasChocolate);

        CheckBox SugarCheckBox = (CheckBox) findViewById(R.id.sugar_checkbox);
        boolean hasSugar = SugarCheckBox. isChecked();
        Log.v("MainActivity", "Has sugar: " + hasSugar);

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, hasSugar);
        displayMessage(priceMessage);

        calculatePrice();
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, boolean addSugar){
        String priceMessage = "Name: ShinConan";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nAdd sugar? " + addSugar;
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