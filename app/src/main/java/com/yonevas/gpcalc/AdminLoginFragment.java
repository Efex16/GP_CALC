package com.yonevas.gpcalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.yonevas.gpcalc.databinding.FragmentAdminLoginBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AdminLoginFragment extends Fragment {

    private FragmentAdminLoginBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentAdminLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        ArrayList<String> originalEmail = new ArrayList<>(Arrays.asList("efeefosa84@gmail.com", "alx_cohort9project@alx.com"));
        ArrayList<String>  originalPassword = new ArrayList<>(Arrays.asList("efex16","alx_9"));
        binding.btnLogin.setOnClickListener(btnLogin->{
            if(originalEmail.contains(convertText(binding.editEmailAddress)) &&
                    originalPassword.contains(convertText(binding.editPassword))){
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_LoginFragment_to_GPAFragment);
            }else {
                binding.editPassword.setError("password or email incorrect");
                binding.editEmailAddress.setError("password or email incorrect");
            }
        });
        return view;

    }

    private String convertText(TextInputEditText editText) {
        return Objects.requireNonNull(editText.getText()).toString();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}