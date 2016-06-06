package com.josepcode.petagramFragments.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.josepcode.petagramFragments.R;
import com.josepcode.petagramFragments.SendMessage;

import org.w3c.dom.Text;

/**
 * Created by JR on 06/06/2016.
 */
public class ContactoActivity extends AppCompatActivity {
    private TextInputLayout     mInput_Name;
    private TextInputLayout     mEmail;
    private TextInputLayout     mMensaje;
    private Button              mEnviar;
    private SendMessage         mSend;

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        mInput_Name     =(TextInputLayout)  findViewById(R.id.input_layout_name);
        mEmail          =(TextInputLayout)  findViewById(R.id.til_email);
        mMensaje        =(TextInputLayout)  findViewById(R.id.til_menasje);
        mEnviar         =(Button)           findViewById(R.id.bt_enviar);


        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDatos();
            }
        });

    }
    public void actualizarDatos(){
        String nombreContacto;
        String email;
        String texto;

        nombreContacto      =mInput_Name.getEditText().getText().toString();
        email               =mEmail.getEditText().getText().toString();
        texto               =mMensaje.getEditText().getText().toString();

        mSend= new SendMessage(nombreContacto ,email,texto);
        System.out.println(mInput_Name.getEditText().getText().toString()+ mEmail.getEditText().getText().toString()+
                mMensaje.getEditText().getText().toString());
        mSend.enviarMensaje();
    }
}
