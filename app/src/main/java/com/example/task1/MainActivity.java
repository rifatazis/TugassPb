package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    private EditText etBeras, etMinyak, etGula;

    private Button btnOk;

    private CheckBox cbBeras, cbMinyak, cbGula;

    private RadioButton rdMember, noMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        etBeras = findViewById(R.id.etBeras);
        etMinyak = findViewById(R.id.etMinyak);
        etGula = findViewById(R.id.etGula);
        btnOk = findViewById(R.id.btnOk);
        cbBeras = findViewById(R.id.cbBeras);
        cbMinyak = findViewById(R.id.cbMinyak);
        cbGula = findViewById(R.id.cbGula);
        rdMember = findViewById(R.id.rdMember);
        noMember = findViewById(R.id.noMember);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();

                int hBeras = 16250;
                int aBeras = 2000;
                int hMinyak = 14594;
                int aMinyak = 2500;
                int hGula = 10000;
                int aGula = 1000;
                int beras = 0;
                int minyak = 0;
                int gula = 0;
                int plBeras=0;
                int plMinyak=0;
                int plGula=0;

                try {
                    if (cbBeras.isChecked()) {
                        int nBeras = Integer.parseInt(etBeras.getText().toString().trim());
                        int tBeras = hBeras * nBeras;
                        beras += tBeras;
                        plBeras = beras + aBeras;
                        result.append("----------------------------------------------------------------------------------------------\n");
                        result.append("Beras 1Kg").append(" x ").append(nBeras).append("                                                                Rp.").append(beras).append("\n");
                        result.append("admin : Rp").append(aBeras).append("                                              Rp. ").append(plBeras).append("\n");
                    }
                    if (cbMinyak.isChecked()) {
                        int nMinyak = Integer.parseInt(etMinyak.getText().toString().trim());
                        int tMinyak = hMinyak * nMinyak;
                        minyak += tMinyak;
                        plMinyak = minyak + aMinyak;
                        result.append("----------------------------------------------------------------------------------------------\n");
                        result.append("Minyak 1 Liter").append(" x ").append(nMinyak).append("                                                          Rp.").append(minyak).append("\n");
                        result.append("admin : Rp").append(aMinyak).append("                                              Rp. ").append(plMinyak).append("\n");
                    }
                    if (cbGula.isChecked()) {
                        int nGula = Integer.parseInt(etGula.getText().toString().trim());
                        int tGula = hGula * nGula;
                        gula += tGula;
                        plGula = gula + aGula;
                        result.append("----------------------------------------------------------------------------------------------\n");
                        result.append("Gula 500 gram").append(" x ").append(nGula).append("                                                          Rp.").append(gula).append("\n");
                        result.append("admin : Rp").append(aGula).append("                                               Rp. ").append(plGula).append("\n");
                    }

                } catch (NumberFormatException e) {
                    result.append("please fill in the quantity\n");
                }

                    int total = plBeras + plMinyak + plGula;

                    if (rdMember.isChecked()) {
                        result.append("------------------------------------------------------------------------------------------\n");
                        Double member = 0.05 * total;
                        total -= member;
                        result.append("Membership discount:                                                5% \n" +
                                      "Total:                                                                         Rp.").append(total).append("\n");
                        result.append("------------------------------------------------------------------------------------------\n");
                    }
                    if (noMember.isChecked()) {
                        result.append("------------------------------------------------------------------------------------------\n");
                        result.append("Membership discount:                                                 0 \n" +
                                      "Total:                                                                         Rp.").append(total).append("\n");
                        result.append("------------------------------------------------------------------------------------------\n");
                    }
                    tvResult.setText(result.toString());
            }
        });

    }
}