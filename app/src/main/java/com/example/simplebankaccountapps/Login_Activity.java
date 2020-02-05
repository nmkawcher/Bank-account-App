package com.example.simplebankaccountapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import javax.security.auth.login.LoginException;

public class Login_Activity extends AppCompatActivity {

    private TextInputEditText accnumET;
    private AccountPreference accountPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accountPreference=new AccountPreference(this);
        if(accountPreference.getloginstutus()){
            int accountNo=accountPreference.getUserAccount();
            BankAccount bankAccount=null;

            for(BankAccount b: TempDa.generateAccount()){

                if(accountNo==b.getaccountNumber()){

                    bankAccount=b;
                }
            }
            Intent intent=new Intent(Login_Activity.this,AccountDetailsActivity.class);
            intent.putExtra("ba",bankAccount);
            startActivity(intent);
        }
        setContentView(R.layout.activity_login_);
        accnumET=findViewById(R.id.login_id);
    }

    public void loginholder(View view) {

        boolean flag=false;



        BankAccount bankAccount=null;


        String accountnumber=accnumET.getText().toString();
        if(!accountnumber.isEmpty()){

            int accountNO=Integer.parseInt(accnumET.getText().toString());

            for(BankAccount b: TempDa.generateAccount()){

                if(accountNO==b.getaccountNumber()){

                    flag=true;
                    bankAccount=b;
                }



            }

            if(flag==true){
                            accountPreference.setLoginstutas(true);
                Intent intent=new Intent(getApplicationContext(),AccountDetailsActivity.class);
                intent.putExtra("ba",bankAccount); //simillar to anoter tag..
                startActivity(intent);
                finish();
            } else{

                Toast.makeText(getApplicationContext(),"account not found: "+accountNO,Toast.LENGTH_SHORT).show();
            }

            finish();
        }
    }

    public void gotomainActivity(View view) {

        startActivity(new Intent(Login_Activity.this,MainActivity.class));
        finish();
    }
}
