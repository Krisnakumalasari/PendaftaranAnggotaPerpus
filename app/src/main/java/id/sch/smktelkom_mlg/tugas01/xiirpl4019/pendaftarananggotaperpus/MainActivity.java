package id.sch.smktelkom_mlg.tugas01.xiirpl4019.pendaftarananggotaperpus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNama, etTL, etTgl;
    RadioGroup rgJK;
    Spinner spKelas;
    CheckBox cbF, cbNF, cbFI, cbI;
    TextView tvHasil;
    Button bOk;

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

        bOk = (Button) findViewById(R.id.buttonOK);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String tl = etTL.getText().toString();
            String tgl = etTgl.getText().toString();
            String hasil = null;
            if (rgJK.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgJK.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            String buku = "menyukai buku: ";
            int startlen = buku.length();
            if (cbF.isChecked()) buku += cbF.getText() + ",";
            if (cbNF.isChecked()) buku += cbNF.getText() + ",";
            if (cbFI.isChecked()) buku += cbFI.getText() + ",";
            if (cbI.isChecked()) buku += cbI.getText() + ",";

            if (buku.length() == startlen) buku += "tidak memilih";

            if (hasil == null) {
                tvHasil.setText("Anda Belum memilih Jenis Kelamin");
            } else {
                tvHasil.setText("Anda yang bernama " + nama + "lahir di " + tl +
                        "pada " + tgl + "yang berjenis kelamin " + hasil + "kelas " + spKelas.getSelectedItem().toString() + buku +
                        "telah mendaftar menjadi anggota perpustakaan SMK Telkom Malang");
            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tl = etTL.getText().toString();
        String tgl = etTgl.getText().toString();

        if (nama.isEmpty())

        {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tl.isEmpty()) {
            etTL.setError("Tempat Lahir belum diisi");
            valid = false;
        } else {
            etTL.setError(null);
        }

        if (tgl.isEmpty()) {
            etTgl.setError("Tanggal Lahir belum diisi dan format harus dd-mm-yyyy");
            valid = false;
        } else {
            etTgl.setError(null);
        }


        return valid;

    }
}
