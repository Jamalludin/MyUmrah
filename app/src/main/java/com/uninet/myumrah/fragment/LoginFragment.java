package com.uninet.myumrah.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uninet.myumrah.MainActivity;
import com.uninet.myumrah.R;
import com.uninet.myumrah.interactor.LoginInteractor;
import com.uninet.myumrah.presenter.presenter_login.LoginPresenter;
import com.uninet.myumrah.presenter.presenter_login.ILoginPresenter;
import com.uninet.myumrah.util.JsonUtil;
import com.uninet.myumrah.model.CommonModel;
import com.uninet.myumrah.view.LoginView;
import com.uninet.myumrah.activity.login_aplikasi.Session;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginView{
    private Button masuk;
    private EditText user,password;
    private ProgressDialog pdialog;
    public static String USER_LOGIN,PASSWORD;
    private ILoginPresenter loginPresenter;
    public static Context CONTEXT;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        user         = (EditText)getActivity().findViewById(R.id.input_id);
        password     = (EditText)getActivity().findViewById(R.id.input_password);
        masuk        = (Button)getActivity().findViewById(R.id.btn_masuk);

        pdialog = new ProgressDialog(getContext());
        loginPresenter = new LoginPresenter(this);
        CONTEXT = getActivity();

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_LOGIN = user.getText().toString();
                PASSWORD   = password.getText().toString();

                loginPresenter.onValidasi(USER_LOGIN,PASSWORD);

            }
        });

        if (new Session(getActivity().getApplicationContext()).cekLogin() == true){
            startActivity(new Intent(getContext(), MainActivity.class));

            getActivity().finish();
        }else {

        }

    }

    @Override
    public void onValidasiLoginSucces(String message) {
        pdialog.setMessage("Please Wait...");
        //pdialog.setCancelable(false);
        pdialog.show();

        login();
    }

    @Override
    public void onValidasiLoginError(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(getContext(), message+" "+USER_LOGIN, Toast.LENGTH_LONG).show();

        pdialog.dismiss();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_LONG).show();

        pdialog.dismiss();
    }

    public void login(){
        final LoginInteractor login = new LoginInteractor(CONTEXT);

        login.LoginRequest(new LoginInteractor.Login() {
            @Override
            public void Hasil(String hasil) {

                if (hasil.equalsIgnoreCase("0")){

                    loginPresenter.onLogin(hasil);
                }else {

                    String status;
                    String token;

                    try {

                        CommonModel commonModel =  JsonUtil.fromJson(hasil, CommonModel.class);
                        status = commonModel.getStatus();
                        token  = commonModel.getData().toString();
                        Log.i("tokenss", token);
                        if (status.equalsIgnoreCase("success")){

                            loginPresenter.onLogin(status);

                            new Session(getActivity().getApplicationContext()).token(USER_LOGIN,PASSWORD,commonModel.getRoles(),token);
                            startActivity(new Intent(getActivity(),MainActivity.class));
                            getActivity().finish();

                        }else {


                        }

                    }catch (Exception e){

                        Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
