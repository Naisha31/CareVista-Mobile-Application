package com.example.carevista;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Diagnostics extends AppCompatActivity {
    private EditText editTextPatientName;
    private Spinner spinnerDiagnosticsTests, spinnerTimeSlots;
    private Button buttonBookAppointment;
    private DatePickerDialog datePickerDialog;
    private Button dateButton, knowmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostics);

        editTextPatientName = findViewById(R.id.editTextPatientName);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        spinnerDiagnosticsTests = findViewById(R.id.spinnerDiagnosticsTests);
        spinnerTimeSlots = findViewById(R.id.spinnerTimeSlots);
        buttonBookAppointment = findViewById(R.id.book);
        knowmore=findViewById(R.id.knowmore);

        // Populate spinner with doctor options
        List<String> testnames = new ArrayList<>();
        testnames.add("Select Tests");
        testnames.add("Blood Test");
        testnames.add("Sugar Test");
        testnames.add("Covid 19 Test");
        testnames.add("Urine Test");

        ArrayAdapter<String> doctorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, testnames);
        doctorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiagnosticsTests.setAdapter(doctorAdapter);

        // Populate spinner with time slot options
        List<String> timeSlots = new ArrayList<>();
        timeSlots.add("Select Time Slot");
        timeSlots.add("09:00 AM");
        timeSlots.add("10:00 AM");
        timeSlots.add("11:00 AM");
        timeSlots.add("01:00 PM");
        timeSlots.add("02:00 PM");

        ArrayAdapter<String> timeSlotAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeSlots);
        timeSlotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTimeSlots.setAdapter(timeSlotAdapter);

        buttonBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment();
            }
        });

        knowmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testnamelink= String.valueOf(spinnerDiagnosticsTests.getSelectedItem());

                if(testnamelink.equals("Blood Test")){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-prepare-for-blood-test#blood-draw-procedure")));
                }
                else if (testnamelink.equals("Sugar Test")){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://synappsehealth.com/en/articles/i/preparation-for-general-urine-testing/")));
                }
                else if (testnamelink.equals("Covid 19 test")){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/testing.html#:~:text=If%20you%20do%20not%20have,more%20reliable%20negative%20test%20result.")));

                } else if (testnamelink.equals("Urine Test")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://synappsehealth.com/en/articles/i/preparation-for-general-urine-testing/")));
                }
                else
                {
                    Toast.makeText(Diagnostics.this, "Please select Test", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void bookAppointment() {
        String testName = spinnerDiagnosticsTests.getSelectedItem().toString();
        String patientName = editTextPatientName.getText().toString().trim();
        String date = dateButton.getText().toString();
        String timeSlot = spinnerTimeSlots.getSelectedItem().toString();

        // You can perform validation here before proceeding

        // Example: If all fields are non-empty
        if (!patientName.isEmpty() && !date.isEmpty()) {
            // Here, you can handle the booking logic, such as sending data to a server, saving to a database, etc.
            // For simplicity, we'll just show a toast message.
            String message = "Your Diagnostics Test booked with " + testName + " on " + date + " at " + timeSlot + " for " + patientName;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }

    }
    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

}