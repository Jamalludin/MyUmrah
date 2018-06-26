package com.uninet.myumrah.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uninet.myumrah.R;
import com.uninet.myumrah.interactor.RegisterInteractor;
import com.uninet.myumrah.presenter.presenter_register.RegisterPresenter;
import com.uninet.myumrah.presenter.presenter_register.IRegisterPresenter;
import com.uninet.myumrah.view.RegisterView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterView {

    private EditText nama,email,noHp,username;
    private Button singup;
    private String txtNama,txtEmail,txtHP,txtUsername;
    private ProgressDialog progressDialog;
    private IRegisterPresenter registerPresenter;
    public static Context context;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nama            = (EditText)getActivity().findViewById(R.id.input_nama);
        email           = (EditText)getActivity().findViewById(R.id.input_email_reg);
        noHp            = (EditText)getActivity().findViewById(R.id.input_telp);
        username        = (EditText)getActivity().findViewById(R.id.input_username);
        singup          = (Button)getActivity().findViewById(R.id.btn_signup);
        progressDialog  = new ProgressDialog(getContext());
        registerPresenter = new RegisterPresenter(this);
        context = getActivity();

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtNama     = nama.getText().toString();
                txtEmail    = email.getText().toString();
                txtHP       = noHp.getText().toString();
                txtUsername = username.getText().toString();

                registerPresenter.onValidasi(txtNama,txtUsername,txtEmail,txtHP);

            }
        });
    }

    @Override
    public void onValidasiSucces(String message) {
        sentData(txtNama,txtUsername,txtEmail,txtHP);
        progressDialog.setMessage("Please Wait...");
        //progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    public void onValidasiError(String message) {

        Toasty.error(getContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRegisterSuccess(String message) {
        nama.setText("");
        username.setText("");
        email.setText("");
        noHp.setText("");

        progressDialog.dismiss();

        Toasty.success(getContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRegisterError(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_LONG).show();

        progressDialog.dismiss();

    }

    private void sentData(final String namaUser, final String user, final String emailUser, final String hpUser){

        Map<String, String> data = new HashMap<String, String>();
        data.put("namaUser",user);
        data.put("namaLengkap",namaUser);
        data.put("password","asdf");
        data.put("email",emailUser);
        data.put("noHp", hpUser);

        JSONObject tes = new JSONObject(data);

        RegisterInteractor request = new RegisterInteractor(context);
        request.RegisterRequest(tes, new RegisterInteractor.Register() {
            @Override
            public void Result(String result) {

                String hasil;

                try {

                    JSONObject objReg = new JSONObject(result);
                    hasil  = objReg.getString("status");

                    registerPresenter.onResgister(hasil);

                }catch (Exception e){

                }

            }
        });
    }
}
