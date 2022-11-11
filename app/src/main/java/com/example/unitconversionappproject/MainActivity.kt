package com.example.unitconversionappproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var usd2leu: RadioButton
    private lateinit var leu2usd: RadioButton
    private lateinit var numInput: EditText
    private lateinit var convertButton: Button
    private lateinit var convertedOutput: TextView

    private val USDformatter = DecimalFormat("\u0024##,###.00")
    val LeuFormatter = DecimalFormat("\u0141##,###.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usd2leu = findViewById(R.id.usd_to_leu)
        leu2usd = findViewById(R.id.leu_to_usd)
        numInput = findViewById(R.id.currency_input)
        convertButton = findViewById(R.id.convert_button)
        convertedOutput = findViewById(R.id.converted_output)

        convertButton.setOnClickListener {
            val number = numInput.text.toString().toDouble()

            //Conversion rate
            val conversionRate = 0.2 //0.2 Leu per USD
            var convertedNumber: Double?

            if (usd2leu.isChecked){
                if (number <= 10000){
                    convertedNumber = number / conversionRate
                    convertedOutput.text = LeuFormatter.format(convertedNumber)
                } else {
                    Toast.makeText(this@MainActivity, "USD Must be less than 10 thousand", Toast.LENGTH_SHORT).show()
                }
            }

            if (leu2usd.isChecked){
                if (number <= 50000){
                    convertedNumber = number * conversionRate
                    convertedOutput.text = USDformatter.format(convertedNumber)
                } else {
                    Toast.makeText(this@MainActivity, "Leu must be less than 50 thousand", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}