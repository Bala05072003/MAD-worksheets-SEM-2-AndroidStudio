package com.example.form_design

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etRoll: EditText
    lateinit var etDob: EditText
    lateinit var actvDept: AutoCompleteTextView
    lateinit var rgGender: RadioGroup
    lateinit var cbReading: CheckBox
    lateinit var cbMusic: CheckBox
    lateinit var cbSports: CheckBox
    lateinit var spProgramme: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etRoll = findViewById(R.id.etRoll)
        etDob = findViewById(R.id.etDob)
        actvDept = findViewById(R.id.actvDept)
        rgGender = findViewById(R.id.rgGender)
        cbReading = findViewById(R.id.cbReading)
        cbMusic = findViewById(R.id.cbMusic)
        cbSports = findViewById(R.id.cbSports)
        spProgramme = findViewById(R.id.spProgramme)

        // AutoCompleteTextView
        val departments = arrayOf("CSE", "IT", "ECE", "EEE", "MCA")
        val deptAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            departments
        )
        actvDept.setAdapter(deptAdapter)

        // Spinner
        val programmes = arrayOf("Select Programme", "UG", "PG", "PhD")
        val progAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            programmes
        )
        spProgramme.adapter = progAdapter

        // Date Picker
        etDob.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    etDob.setText("$day/${month + 1}/$year")
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            submitForm()
        }
    }

    private fun submitForm() {

        if (etName.text.isEmpty()) {
            etName.error = "Enter Name"
            return
        }

        if (etRoll.text.isEmpty()) {
            etRoll.error = "Enter Roll No"
            return
        }

        if (rgGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show()
            return
        }

        var hobbies = ""
        if (cbReading.isChecked) hobbies += "Reading "
        if (cbMusic.isChecked) hobbies += "Music "
        if (cbSports.isChecked) hobbies += "Sports "

        val gender =
            findViewById<RadioButton>(rgGender.checkedRadioButtonId).text

        val data = """
            Name      : ${etName.text}
            Roll No   : ${etRoll.text}
            Dept      : ${actvDept.text}
            Gender    : $gender
            Hobbies   : $hobbies
            Programme : ${spProgramme.selectedItem}
            DOB       : ${etDob.text}
        """.trimIndent()

        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("details", data)
        startActivity(intent)
    }
}
