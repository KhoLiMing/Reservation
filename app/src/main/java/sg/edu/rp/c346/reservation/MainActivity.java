package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

EditText editTextName;
EditText editTextMobile;
EditText editTextSize;
DatePicker dp;
TimePicker tp;
CheckBox cb;
Button buttonConfirm;
Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName=findViewById(R.id.editTextName);
        editTextMobile=findViewById(R.id.editTextMobile);
        editTextSize=findViewById(R.id.editTextSize);
        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        cb=findViewById(R.id.checkBox);
        buttonConfirm=findViewById(R.id.buttonConfirm);
        buttonReset=findViewById(R.id.buttonReset);


        buttonConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = ("Name: " + editTextName.getText().toString());
                String Mobile = ("Mobile Number: " + editTextMobile.getText().toString());
                String Size = (" Size Of Group: " + editTextSize.getText().toString() );
                String date = (" Date: " + + dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear());
                String time = ("Time:  "+ tp.getCurrentHour() + ":" + tp.getCurrentMinute());
                String smoke=("Table is in non-smoking area ");
                if(cb.isChecked()) {
                  smoke = ("Table is in smoking area ");
                }
                Toast.makeText(getApplicationContext(), name + "\n" + Mobile + "\n" +Size +"\n" + date +
                        "\n" + time + "\n" + smoke ,Toast.LENGTH_SHORT).show();
            }
        } );

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setText("");
                editTextMobile.setText("");
                editTextSize.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2019 , 5, 1);
                cb.setChecked(false);
            }
        });
    }
}
