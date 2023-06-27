package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate:TextView?= null
private var tvAgeInMinutes : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val btndatepicker : Button=findViewById(R.id.btndatepicker)


        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)



         btndatepicker.setOnClickListener{

             clickdatepicker()


         }



    }

    fun clickdatepicker(){

       val myCalendar= Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
        {selectedview, selectedyear, selectedmonth, selecteddayofmonth->

            Toast.makeText(this,
                " Year was $selectedyear, month was ${selectedmonth+1}, day of month was $selecteddayofmonth",
                Toast.LENGTH_LONG).show()

            val selectedDate = "$selecteddayofmonth/${selectedmonth+1}/$selectedyear"

            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate.time / 60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes = currentDate.time/ 60000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            tvAgeInMinutes?.text = differenceInMinutes.toString()

        },
            year,
            month,
            day

        ).show()





        // DatePickerDialog()



    }


}