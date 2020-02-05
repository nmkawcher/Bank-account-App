package com.example.simplebankaccountapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText accNameET,ageET,EmailET,PhoneEt,BalenceEt;
    private RadioGroup accounttypeRG;
    private int accountTypeIndex=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accNameET=findViewById(R.id.AccountNameID);
        ageET=findViewById(R.id.UserAgeID);
        PhoneEt=findViewById(R.id.PhoneNumberId);
        EmailET=findViewById(R.id.UserEmailID);
        BalenceEt=findViewById(R.id.user_initialbalance_id);
        accounttypeRG=findViewById(R.id.AccountTypeRG_ID);


        accounttypeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                accountTypeIndex=group.
                        indexOfChild(findViewById(group.getCheckedRadioButtonId()));

                Toast.makeText(getApplicationContext(),"index number"+accountTypeIndex,Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void OpenNewAccount(View view) {

        String name=accNameET.getText().toString();
        String age=ageET.getText().toString();
        String phone=PhoneEt.getText().toString();
        String email=EmailET.getText().toString();
        String balance=BalenceEt.getText().toString();

        final RadioButton rb=findViewById(accounttypeRG.getCheckedRadioButtonId());
        String accounttype=rb.getText().toString();
        BankAccount bankAccount;
        Intent intent=new Intent(MainActivity.this,AccountDetailsActivity.class);



        switch (accountTypeIndex){

            case 0:

                bankAccount=new SavingsAccount(name,
                        0001,
                        Integer.parseInt(age),
                        phone,
                        email,
                        Double.parseDouble(balance),
                        accountTypeIndex
                        );
               intent.putExtra("ba", (Serializable) bankAccount);

                break;

            case 1:

                bankAccount=new CheckingAccount(
                        name,
                        0001,
                        Integer.parseInt(age),
                        phone,
                        email,
                        Double.parseDouble(balance),
                        accountTypeIndex


                );

                intent.putExtra("ba",bankAccount);
                break;
        }

        startActivity(intent);

        }

    public void gotoLoginActivity(View view) {

        startActivity(new Intent(MainActivity.this,Login_Activity.class));
        finish();
    }
}
