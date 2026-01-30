package com.example.payment

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.payment.R

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val spCardType = findViewById<Spinner>(R.id.spCardType)
        val spCountry = findViewById<Spinner>(R.id.spCountry)
        val etCard = findViewById<EditText>(R.id.etCardNumber)
        val etExpiry = findViewById<EditText>(R.id.etExpiry)
        val etCvv = findViewById<EditText>(R.id.etCvv)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etCity = findViewById<EditText>(R.id.etCity)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Spinner Adapters
        spCardType.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Select Card Type", "Visa", "MasterCard", "RuPay")
        )

        spCountry.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Select Country", "India", "USA", "UK")
        )

        btnSubmit.setOnClickListener {

            // Validation
            if (spCardType.selectedItemPosition == 0) {
                toast("Select card type")
                return@setOnClickListener
            }

            if (etCard.text.length != 16) {
                toast("Card number must be 16 digits")
                return@setOnClickListener
            }

            if (etCvv.text.length != 3) {
                toast("CVV must be 3 digits")
                return@setOnClickListener
            }

            if (etAddress.text.isEmpty() || etCity.text.isEmpty()) {
                toast("Enter billing address details")
                return@setOnClickListener
            }

            if (spCountry.selectedItemPosition == 0) {
                toast("Select country")
                return@setOnClickListener
            }

            // Pass data using Intent
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("cardType", spCardType.selectedItem.toString())
            intent.putExtra("cardNumber", etCard.text.toString())
            intent.putExtra("expiry", etExpiry.text.toString())
            intent.putExtra("cvv", etCvv.text.toString())
            intent.putExtra("address", etAddress.text.toString())
            intent.putExtra("city", etCity.text.toString())
            intent.putExtra("country", spCountry.selectedItem.toString())

            startActivity(intent)
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
