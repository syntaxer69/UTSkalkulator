package com.kalkulator.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditTextBilanganPertama = findViewById<EditText>(R.id.et_bilangan_pertama)
        val mEditTextBilanganKedua = findViewById<EditText>(R.id.et_bilangan_kedua)
        val mSpinnerOperator = findViewById<Spinner>(R.id.spn_operator)
        val mButtonHitung = findViewById<Button>(R.id.btn_hitung)
        val mTextViewHasil = findViewById<TextView>(R.id.tv_hasil)

        mButtonHitung.setOnClickListener {
            if (mEditTextBilanganPertama.text.toString() == "") {
                mEditTextBilanganPertama.error = "Kamu Belum Memasukkan Bilangan Pertama"
                return@setOnClickListener
            }

            if (mEditTextBilanganKedua.text.toString() == "") {
                mEditTextBilanganKedua.error = "Kamu Belum Memasukkan Bilangan Kedua"
                return@setOnClickListener
            }

            val mBilanganPertama = mEditTextBilanganPertama.text.toString().toDouble()
            val mBilanganKedua = mEditTextBilanganKedua.text.toString().toDouble()

            val mOperator = mSpinnerOperator.selectedItem.toString()

            var mHasilPerhitungan = 0.0

            when (mOperator) {
                "+" -> mHasilPerhitungan = mBilanganPertama + mBilanganKedua
                "-" -> mHasilPerhitungan = mBilanganPertama - mBilanganKedua
                "x" -> mHasilPerhitungan = mBilanganPertama * mBilanganKedua
                "/" -> mHasilPerhitungan = mBilanganPertama / mBilanganKedua
                else -> {
                    Toast.makeText(this, "Kamu belum memilih operator", Toast.LENGTH_SHORT).show()
                }
            }

            mTextViewHasil.text = mHasilPerhitungan.toString()
        }
    }
}