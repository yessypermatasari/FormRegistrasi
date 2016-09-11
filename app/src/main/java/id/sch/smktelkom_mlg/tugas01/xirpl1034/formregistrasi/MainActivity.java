package id.sch.smktelkom_mlg.tugas01.xirpl1034.formregistrasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etTahun;
    RadioGroup rgJk;
    Spinner spkelas;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    Button bOk;
    TextView tvHasil, tvKelas;
    int nKelas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTanggal);
        rgJk = (RadioGroup) findViewById(R.id.radioGroupJenis);
        spkelas = (Spinner) findViewById(R.id.spinnerKelas);
        cb1 = (CheckBox) findViewById(R.id.checkBoxVE);
        cb2 = (CheckBox) findViewById(R.id.checkBoxJ);
        cb3 = (CheckBox) findViewById(R.id.checkBoxD);
        cb4 = (CheckBox) findViewById(R.id.checkBoxDG);
        cb5 = (CheckBox) findViewById(R.id.checkBoxDW);
        bOk = (Button) findViewById(R.id.buttonOK);
        cb4 = (CheckBox) findViewById(R.id.checkBoxDG);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvKelas = (TextView) findViewById(R.id.textView5);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String hasil = null;
        String asal = spkelas.getSelectedItem().toString();
        String kelas = "\n Kelas Anda           : ";

        int startlen = kelas.length();
        if (cb1.isChecked()) kelas += cb1.getText() + ",";
        if (cb2.isChecked()) kelas += cb2.getText() + ",";
        if (cb3.isChecked()) kelas += cb3.getText() + ",";
        if (cb4.isChecked()) kelas += cb4.getText();

        if (kelas.length() == startlen) kelas += "Tidak ada pada pilihan";

        if (rgJk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJk.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Belum Diisi");
        } else if (tahun.length() > 2) {
            etTahun.setError("Format Umur Salah");
        } else {
            etNama.setError(null);
        }
        tvHasil.setText("------ METIC -----" + "\nNama         : " + nama + " \nUmur         : " + tahun +
                "\nJenis Kelamin     : " + hasil + "\nAsal kelas     : " + asal + kelas);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nKelas += 1;
        else nKelas -= 1;
        tvKelas.setText("Hobi (" + nKelas + " terpilih)");
    }
}
