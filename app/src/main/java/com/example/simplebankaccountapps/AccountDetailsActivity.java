package com.example.simplebankaccountapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class AccountDetailsActivity extends AppCompatActivity implements Serializable {

    private TextView accNameTV,accountTypeTV,accountNumberTV,phoneTV,emailTV,balanceTV,rateTV,chargeTV;
    private TableRow chargeRow,rateRow;
    private BankAccount bankAccount;
    private AccountPreference accountPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accountPreference=new AccountPreference(this);

        setContentView(R.layout.activity_account_details);

        initvalue();

        Intent intent=getIntent();
         bankAccount= (BankAccount) intent.getSerializableExtra("ba");

       if(bankAccount !=null){

           displayInforIntoViews(bankAccount);
       }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.profile_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.logout_id :
                    accountPreference.setLoginstutas(false);
                    accountPreference.setUserAccount(-1);
                finish();
                startActivity(new Intent(AccountDetailsActivity.this,Login_Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayInforIntoViews(BankAccount bankAccount) {

        accNameTV.setText(bankAccount.getAccName());
        accountNumberTV.setText(String.valueOf(bankAccount.getaccountNumber()));

        accountTypeTV.setText(getAccountTypeString(bankAccount.getaccountType()));
        phoneTV.setText(bankAccount.getPhone());
        emailTV.setText(bankAccount.getEmail());
        balanceTV.setText(String.valueOf(bankAccount.getbalance()));

  detarmineAccountType(bankAccount);
    }

    private void detarmineAccountType(BankAccount bankAccount) {

                switch (bankAccount.getaccountType()){

                    case 0:
                        SavingsAccount sa= (SavingsAccount) bankAccount;
                        rateRow.setVisibility(View.VISIBLE);
                        chargeRow.setVisibility(View.GONE);
                        rateTV.setText(String.valueOf(sa.getInterestRate()));
                        break;

                    case 1:
                        CheckingAccount ca= (CheckingAccount) bankAccount;
                        chargeTV.setText(String.valueOf(ca.getServiceCharge()));
                        break;
                }
    }

    private String getAccountTypeString(int accountType) {

      switch (accountType){

          case 0:
              return getString(R.string.saving_account);//save in strinng

          case 1:
              return getString(R.string.checking_account);

              default:
                  return "Unknown";
      }
    }

    private void initvalue() {

        chargeRow=findViewById(R.id.serviceChargeRowID);
        rateRow=findViewById(R.id.interestrate_RowID);
        accNameTV=findViewById(R.id.accNameTVID);
        accountTypeTV=findViewById(R.id.acctypeTV_ID);
        accountNumberTV=findViewById(R.id.accNumberTVID);
        phoneTV=findViewById(R.id.accphoneTV_ID);
        emailTV=findViewById(R.id.accEmailTVID);
        balanceTV=findViewById(R.id.accbalanceTVID);
        rateTV=findViewById(R.id.accInterestTV_ID);
        chargeTV=findViewById(R.id.accServicechargeTV_ID);


    }

    public void withdrawmoney(View view) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        final EditText editText=new EditText(this);
        builder.setTitle("Withdraw");
        editText.setHint("enter your withdraw ammount please");
       builder.setView(editText);
        builder.setPositiveButton("withdraw", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String ammount=editText.getText().toString();

                  final String msg=  bankAccount.withdraw(Double.parseDouble(ammount));
                showtransactionMessage(msg);
                    balanceTV.setText(String.valueOf(bankAccount.getbalance()));


               // Toast.makeText(getApplicationContext(),ammount,Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("cancell",null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    private AlertDialog showtransactionMessage(String msg){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Transaction");
        builder.setMessage(msg);
        builder.setPositiveButton("ok",null);
        builder.create();
        return builder.show();
    }

    public void depositmoney(View view) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        final  EditText editText=new EditText(this);
        builder.setTitle("Deposite");
        editText.setHint("enter your ammount");
        builder.setView(editText);

        builder.setPositiveButton("Deposit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String ammount=editText.getText().toString();
                final String msg=bankAccount.deposit(Double.parseDouble(ammount));
                showtransactionMessage(msg);
                balanceTV.setText(String.valueOf(bankAccount.getbalance()));
            }
        });
        builder.setNegativeButton("cancell",null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
