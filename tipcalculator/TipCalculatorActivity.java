package edu.qc.seclass.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        Button compute = findViewById(R.id.buttonCompute);
        compute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    EditText checkAmountText = findViewById(R.id.checkAmountValue);
                    double checkAmount = Double.parseDouble(checkAmountText.getText().toString());

                    EditText partySizeText = findViewById(R.id.partySizeValue);
                    int partySize = Integer.parseInt(partySizeText.getText().toString());

                    if(checkAmount == 0 || partySize == 0) throw new Exception();

                    double totalPerPerson = checkAmount/partySize;

                    int fifteenTip = (int) Math.round(.15*totalPerPerson);
                    int twentyTip = (int) Math.round(.2*totalPerPerson);
                    int twentyFiveTip = (int) Math.round(.25*totalPerPerson);
                    int fifteenTotal = (int) Math.round(fifteenTip+totalPerPerson);
                    int twentyTotal = (int) Math.round(twentyTip+totalPerPerson);
                    int twentyFiveTotal = (int) Math.round(twentyFiveTip+totalPerPerson);

                    TextView fifteenTipValue = findViewById(R.id.fifteenPercentTipValue);
                    fifteenTipValue.setText(new Integer(fifteenTip).toString());

                    TextView twentyTipValue = findViewById(R.id.twentyPercentTipValue);
                    twentyTipValue.setText(new Integer(twentyTip).toString());

                    TextView twentyFiveTipValue = findViewById(R.id.twentyfivePercentTipValue);
                    twentyFiveTipValue.setText(new Integer(twentyFiveTip).toString());

                    TextView fifteenTotalValue = findViewById(R.id.fifteenPercentTotalValue);
                    fifteenTotalValue.setText(new Integer(fifteenTotal).toString());

                    TextView twentyTotalValue = findViewById(R.id.twentyPercentTotalValue);
                    twentyTotalValue.setText(new Integer(twentyTotal).toString());

                    TextView twentyFiveTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
                    twentyFiveTotalValue.setText(new Integer(twentyFiveTotal).toString());

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
    }

}
