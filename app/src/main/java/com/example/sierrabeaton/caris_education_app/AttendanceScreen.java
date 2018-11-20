package com.example.sierrabeaton.caris_education_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class AttendanceActivity extends ListActivity  implements View.OnClickListener{

    Button btnAdd,btnGetAll;
    TextView student_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,StudentDetail.class);
            intent.putExtra("student_Id",0);
            startActivity(intent);

        }else {

            StudentRepo repo = new StudentRepo(this);

            ArrayList<HashMap<String, String>> studentList =  repo.getStudentList();
            if(studentList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        student_Id = (TextView) view.findViewById(R.id.student_Id);
                        String studentId = student_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),StudentDetail.class);
                        objIndent.putExtra("student_Id", Integer.parseInt( studentId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( AttendanceActivity.this,studentList, R.layout.new_student_entry, new String[] { "id","name"}, new int[] {R.id.student_Id, R.id.student_name});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No student!",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_screen);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

    }
    public class AttendanceScreen extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_attendance_screen);
        }

        //Button to Attendance page
        public void b_attendance(View view) {
            startActivity(new Intent(this, com.example.sierrabeaton.caris_education_app.AttendanceScreen.class));
        }

        //Button to Lessons page
        public void b_lessons(View view) {
            startActivity(new Intent(this, LessonScreen.class));
        }

        //Buttons to Feedback page
        public void b_feedback(View view) {
            startActivity(new Intent(this, FeedbackScreen.class));
        }
    }


}