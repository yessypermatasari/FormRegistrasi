package id.sch.smktelkom_mlg.tugas01.xirpl1034.formregistrasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etTahun;
    RadioGroup rgJk;
    Spinner spkelas, spkel;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    Button bOk;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;
    int nKelas;

    String[][] arkel = {
            {"RPL1", "RPL2", "RPL3", "RPL4", "RPL5"},
            {"RPL6", "TKJ1", "TKJ2"},
            {"TKJ3", "TKJ4", "TKJ5"},
            {"TKJ6"}
    };
    ArrayList<String> listKelas = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTanggal);
        spkelas = (Spinner) findViewById(R.id.spinnerKelas);
        spkel = (Spinner) findViewById(R.id.spinnerkel);
        rgJk = (RadioGroup) findViewById(R.id.radioGroupJenis);
        cb1 = (CheckBox) findViewById(R.id.checkBoxVE);
        cb2 = (CheckBox) findViewById(R.id.checkBoxJ);
        cb3 = (CheckBox) findViewById(R.id.checkBoxD);
        cb4 = (CheckBox) findViewById(R.id.checkBoxDG);
        cb5 = (CheckBox) findViewById(R.id.checkBoxDW);
        bOk = (Button) findViewById(R.id.buttonOK);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listKelas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spkel.setAdapter(adapter);

        spkelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listKelas.clear();
                listKelas.addAll(Arrays.asList(arkel[pos]));
                adapter.notifyDataSetChanged();
                spkel.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String hasil2 = "Kelas yang dipilih :    : ";
        String hasil3 = null;
        int startlen = hasil2.length();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() <= 2) {
            etNama.setError("Nama minimal 3 karakter");
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tanggal Lahir belum diiisi");
        } else if (tahun.length() != 4) {
            etTahun.setError("Format Tanggal Lahir Salah");
        } else {
            etTahun.setError(null);
        }
        tvHasil.setText("Nama                      : " + nama + "\nTahun Lahir         : " + tahun);
        tvHasil2.setText("Asal                         : " + "Asal Kelas " + spkel.getSelectedItem().toString() + ", "
                + spkelas.getSelectedItem().toString());
        if (rgJk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJk.getCheckedRadioButtonId());
            hasil3 = rb.getText().toString();
        }
        if (hasil3 == null) {
            tvHasil3.setText("Jenis Kelamin        : -");
        } else {
            tvHasil3.setText("Jenis Kelamin        : " + hasil3);
        }

        if (cb1.isChecked()) hasil2 += cb1.getText() + ", ";
        if (cb2.isChecked()) hasil2 += cb2.getText() + ", ";
        if (cb3.isChecked()) hasil2 += cb3.getText() + ". ";
        if (cb4.isChecked()) hasil2 += cb4.getText() + ". ";
        if (cb5.isChecked()) hasil2 += cb5.getText() + ". ";
        if (hasil2.length() == startlen) hasil2 += "Tidak ada pada Pilihan";
        tvHasil4.setText(hasil2);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nKelas += 1;
        else nKelas -= 1;

    }
}
