package id.sch.smktelkom_mlg.tugas01.xiirpl4019.pendaftarananggotaperpus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNama, etTL, etTgl;
    RadioGroup rgJK;
    Spinner spKelas;
    CheckBox cbF, cbNF, cbFI, cbI;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTL = (EditText) findViewById(R.id.editTextTL);
        etTgl = (EditText) findViewById(R.id.editTextTgl);

        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);

        spKelas = (Spinner) findViewById(R.id.spinnerKelas);

        cbF = (CheckBox) findViewById(R.id.checkBoxF);
        cbNF = (CheckBox) findViewById(R.id.checkBoxNF);
        cbFI = (CheckBox) findViewById(R.id.checkBoxFI);
        cbI = (CheckBox) findViewById(R.id.checkBoxI);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

    }
}
