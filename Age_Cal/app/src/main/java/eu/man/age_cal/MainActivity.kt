package eu.man.age_cal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinutes: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker) // getting that button by id.
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeinMinutes)
        btnDatePicker.setOnClickListener{
            clickDatePicker()

        }
    }

    private fun clickDatePicker(){


        val myCalendar = Calendar.getInstance()  // creating a variable of calendar..
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd =  DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view,selectedyear,selectedmonth,
                                                                             selecteddayofMonth ->
            Toast.makeText(this,"datepicker works",Toast.LENGTH_SHORT).show()

            val selectedDate = "$selecteddayofMonth/${selectedmonth+1}/$selectedyear"

            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            theDate?.let {
                val selectedDateinMinutes = theDate.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let {
                    val currentDateinMinutes = currentDate.time / 60000

                    val differenceInMinutes = currentDateinMinutes - selectedDateinMinutes

                    tvAgeInMinutes?.text = differenceInMinutes.toString()
                }

            }



        }, year, month, day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000   // to prevent a to select
        // a date in future
        dpd.show()


    }
}