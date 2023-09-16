package com.test.myapplication


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateSelected = findViewById<AppCompatButton>(R.id.iv_date_selected)
        val tvDateResult = findViewById<AppCompatTextView>(R.id.tv_date_result)
        val timeSelected = findViewById<AppCompatButton>(R.id.iv_time_selected)
        val tvTimeResult = findViewById<AppCompatTextView>(R.id.tv_time_result)
        val btnMenu = findViewById<AppCompatButton>(R.id.btn_menu)
        val btnSave = findViewById<AppCompatButton>(R.id.btn_save)

        dateSelected.setOnClickListener {
            showDatePicker(this@MainActivity, tvDateResult)
        }

        timeSelected.setOnClickListener {
            showTimePicker(tvTimeResult)
        }
        btnSave.setOnClickListener {
            val intent = Intent(this, ThankYou::class.java)
            startActivity(intent)
        }
        btnMenu.setOnClickListener {
            val intent = Intent(this, ListMenu::class.java)
            startActivity(intent)
        }

    }

    fun showDatePicker(context: Context, textView: TextView, setValue: ((date: String) -> Unit)? = null
    ) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            { view, year, monthOfYear, dayOfMonth ->
                val date = "$dayOfMonth/${monthOfYear + 1}/$year"
                val calendar = Calendar.getInstance()
                calendar.set(year, monthOfYear, dayOfMonth)
                val sdf = SimpleDateFormat("EEEE", Locale("in", "ID"))
                val formattedDayOfWeek = sdf.format(calendar.time)
                textView.text = "$formattedDayOfWeek, $date"
                val monthValue = monthOfYear + 1
                setValue?.invoke("$year-$monthValue-$dayOfMonth")
            },
            year, month, day,
        )
        datePickerDialog.show()
    }

    private fun showTimePicker(textView: TextView) {
        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
               textView.text =  "$hourOfDay:$minute"
            },
            currentHour,
            currentMinute,
            true
        )

        timePickerDialog.show()
    }
}