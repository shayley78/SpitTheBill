package net.androidbootcamp.spitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculate extends AppCompatActivity {
    final double tipPercentage = .18;
    double amountOfBill;
    int numberOfPeople;
    double tipAmount;
    double totalPlusTip;
    double splitTotal;
    String serviceChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        final EditText bill = (EditText)findViewById(R.id.txtAmount);
        final EditText people = (EditText)findViewById(R.id.txtNumPeople);
        final Spinner service = (Spinner)findViewById(R.id.txtService);
        Button cost = (Button)findViewById(R.id.btnCalculate);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView tipResult = ((TextView)findViewById(R.id.txtTipResult));
            final TextView splitResult = ((TextView)findViewById(R.id.txtSplitResult));
            public void onClick(View v) {
                amountOfBill = Double.parseDouble(bill.getText().toString());
                numberOfPeople = Integer.parseInt(people.getText().toString());
                tipAmount = amountOfBill * tipPercentage;
                totalPlusTip = amountOfBill + tipAmount;
                splitTotal = totalPlusTip / numberOfPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                serviceChoice = service.getSelectedItem().toString();
                tipResult.setText("The 18% tip amount for " + serviceChoice + " service is " + currency.format(tipAmount));
                splitResult.setText("The individual share of the " + currency.format(totalPlusTip) + " bill, per person, is " + currency.format(splitTotal));
            }
        });
    }
}
