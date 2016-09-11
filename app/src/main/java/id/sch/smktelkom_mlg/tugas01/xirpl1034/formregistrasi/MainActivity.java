package id.sch.smktelkom_mlg.tugas01.xirpl1034.formregistrasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    RadioGroup rgJk;
    Spinner spkelas;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    Button bOk;
    TextView tvHasil, tvKelas;
    int Kelas;


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
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvKelas = (TextView) findViewById(R.id.textView5);

    }
}
