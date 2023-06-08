package com.yonevas.gpcalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.yonevas.gpcalc.databinding.FragmentSecondBinding;

import java.text.DecimalFormat;
import java.util.Objects;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    DecimalFormat n = new DecimalFormat("#.##");

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


//      setup adapter for destination spinner and populate its list
        ArrayAdapter<CharSequence> studentSpinnerAdapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.students, android.R.layout.simple_spinner_item
        );
        studentSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerStudent.setAdapter(studentSpinnerAdapter);

        ArrayAdapter<CharSequence> gpaSpinnerAdapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.base_gpa, android.R.layout.simple_spinner_item
        );
        gpaSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerBaseGpa.setAdapter(gpaSpinnerAdapter);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnCompute.setOnClickListener(btnCompute -> {
            computeGP(view);
        });
        binding.btnLogout.setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_GPAFragment_to_LoginFragment));
    }

    private void computeGP(View view) {

        setGrades(view);

        double[] unit = new double[9];
        int totalLoad = 0;
        try {
            String[] load = {
                    convertText(binding.load1), convertText(binding.load2),
                    convertText(binding.load3), convertText(binding.load4),
                    convertText(binding.load5), convertText(binding.load6),
                    convertText(binding.load7), convertText(binding.load8),
                    convertText(binding.load9)};
           /* for(int i=1;i<=9;i++){
                unit[i] = computeUnit(((TextView)findViewById(R.id.grade+i)).getText().toString(), load[i]);
                if (load[i].trim().length()>0 ) {
                    try {
                        totalLoad += Integer.parseInt(load[i]);
                    } catch (NumberFormatException e) {
                        Toast.makeText(requireContext(), "Wrong input!\n enter numbers only in your unit column" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }else{
                    totalLoad +=0;
                }
            }*/


            unit[0] = computeUnit(((TextView) view.findViewById(R.id.grade1)).getText().toString(), load[0]);
            unit[1] = computeUnit(((TextView) view.findViewById(R.id.grade2)).getText().toString(), load[1]);
            unit[2] = computeUnit(((TextView) view.findViewById(R.id.grade3)).getText().toString(), load[2]);
            unit[3] = computeUnit(((TextView) view.findViewById(R.id.grade4)).getText().toString(), load[3]);
            unit[4] = computeUnit(((TextView) view.findViewById(R.id.grade5)).getText().toString(), load[4]);
            unit[5] = computeUnit(((TextView) view.findViewById(R.id.grade6)).getText().toString(), load[5]);
            unit[6] = computeUnit(((TextView) view.findViewById(R.id.grade7)).getText().toString(), load[6]);
            unit[7] = computeUnit(((TextView) view.findViewById(R.id.grade8)).getText().toString(), load[7]);
            unit[8] = computeUnit(((TextView) view.findViewById(R.id.grade9)).getText().toString(), load[8]);

            for (int i = 0; i <= 8; i++) {
                if (load[i].trim().length() > 0) {
                    try {
                        totalLoad += Integer.parseInt(load[i]);
                    } catch (NumberFormatException e) {
                        Toast.makeText(requireContext(), "Wrong input!\n enter numbers only in your unit column" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    totalLoad += 0;
                }
            }
            double totalUnit = unit[0] + unit[1] + unit[2] + unit[3] + unit[4] + unit[5] + unit[6] + unit[7] + unit[8];
            if (totalLoad == 0) {
                Toast.makeText(requireContext(), "Please enter at least one score\nand its corresponding credit unit", Toast.LENGTH_LONG).show();
            } else {
                String gp = "GP:= " + n.format(totalUnit / totalLoad);
                ((TextView) view.findViewById(R.id.gp)).setText(gp);
            }
        } catch (Exception ex) {
            Toast.makeText(requireContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String computeGrade(String scoreIn) {
        int score = 0;
        String grade = "";
        if (scoreIn.trim().length() > 0) {
            try {
                score = Integer.parseInt(scoreIn);
                if (score < 100) {
                    if (score >= 0) {
                        if (binding.spinnerBaseGpa.getSelectedItemPosition() == 1) {
                            if (score >= 70) {
                                grade = "A";
                            } else if (score >= 60) {
                                grade = "B";
                            } else if (score >= 50) {
                                grade = "C";
                            } else if (score >= 45) {
                                grade = "D";
                            } else if (score >= 40) {
                                grade = "E";
                            } else {
                                grade = "F";
                            }
                        } else {
                            if (score >= 75) {
                                grade = "A";
                            } else if (score >= 70) {
                                grade = "AB";
                            } else if (score >= 65) {
                                grade = "B";
                            } else if (score >= 60) {
                                grade = "BC";
                            } else if (score >= 55) {
                                grade = "C";
                            } else if (score >= 50) {
                                grade = "CD";
                            } else if (score >= 45) {
                                grade = "D";
                            } else if (score >= 40) {
                                grade = "P";
                            } else if (score >= 30) {
                                grade = "F3";
                            } else if (score >= 20) {
                                grade = "F2";
                            } else if (score >= 10) {
                                grade = "F1";
                            } else {
                                grade = "F0";
                            }
                        }
                    } else {
                        Toast.makeText(requireContext(), "Wrong input!\n enter numbers greater than or equal to zero ", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "Wrong input!\n enter numbers less than 100", Toast.LENGTH_LONG).show();
                }

            } catch (NumberFormatException e) {
                Toast.makeText(requireContext(), "Wrong input!\n enter numbers only in your score column", Toast.LENGTH_LONG).show();
            }
        } else {
            grade = binding.spinnerBaseGpa.getSelectedItemPosition() != 1 ? "F0" : "F";
        }
        return grade;
    }

    private double computeUnit(String grade, String loadIn) {
        double unit = 0;
        int load = 0;
        if (loadIn.trim().length() > 0) {
            try {
                load = Integer.parseInt(loadIn);

                if (binding.spinnerBaseGpa.getSelectedItemPosition() == 1) {
                    if ("A".equals(grade)) {
                        unit = (load * 5.0);
                    } else if ("B".equals(grade)) {
                        unit = (load * 4.0);
                    } else if ("C".equals(grade)) {
                        unit = (load * 3.0);
                    } else if ("D".equals(grade)) {
                        unit = (load * 2.0);
                    } else if ("E".equals(grade)) {
                        unit = (load * 1.0);
                    } else {
                        unit = (load * 0.0);
                    }
                } else {
                    if ("A".equals(grade)) {
                        unit = (load * 4.0);
                    } else if ("AB".equals(grade)) {
                        unit = (load * 3.50);
                    } else if ("B".equals(grade)) {
                        unit = (load * 3.25);
                    } else if ("BC".equals(grade)) {
                        unit = (load * 3.00);
                    } else if ("C".equals(grade)) {
                        unit = (load * 2.75);
                    } else if ("CD".equals(grade)) {
                        unit = (load * 2.50);
                    } else if ("D".equals(grade)) {
                        unit = (load * 2.25);
                    } else if ("P".equals(grade)) {
                        unit = (load * 2.00);
                    } else if ("F3".equals(grade)) {
                        unit = (load * 1.50);
                    } else if ("F2".equals(grade)) {
                        unit = (load * 1.00);
                    } else if ("F1".equals(grade)) {
                        unit = (load * 0.50);
                    } else if ("F0".equals(grade)) {
                        unit = (load * 0.00);
                    }
                }

            } catch (NumberFormatException e) {
                Toast.makeText(requireContext(), "Wrong input!\n enter numbers only in your score column", Toast.LENGTH_LONG).show();
            }
        } else {
            unit = (load * 0.0);
        }
        return unit;
    }

    private void setGrades(View view) {
        String[] grades = {
                convertText(binding.score1), convertText(binding.score2),
                convertText(binding.score3), convertText(binding.score4),
                convertText(binding.score5), convertText(binding.score6),
                convertText(binding.score7), convertText(binding.score8),
                convertText(binding.score9)};

        try {
            ((TextView) view.findViewById(R.id.grade1)).setText(computeGrade(grades[0]));
            ((TextView) view.findViewById(R.id.grade2)).setText(computeGrade(grades[1]));
            ((TextView) view.findViewById(R.id.grade3)).setText(computeGrade(grades[2]));
            ((TextView) view.findViewById(R.id.grade4)).setText(computeGrade(grades[3]));
            ((TextView) view.findViewById(R.id.grade5)).setText(computeGrade(grades[4]));
            ((TextView) view.findViewById(R.id.grade6)).setText(computeGrade(grades[5]));
            ((TextView) view.findViewById(R.id.grade7)).setText(computeGrade(grades[6]));
            ((TextView) view.findViewById(R.id.grade8)).setText(computeGrade(grades[7]));
            ((TextView) view.findViewById(R.id.grade9)).setText(computeGrade(grades[8]));

        } catch (NumberFormatException ex) {
            Toast.makeText(requireContext(), "Wrong inpute! characters,space(s)... are not allowed\n " +
                    "enter numbers only in the appropriate locations" + ex.getMessage(), Toast.LENGTH_LONG).show();
            //       + "\n click ok to continue", "error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private String convertText(EditText editText) {
        return Objects.requireNonNull(editText.getText()).toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}