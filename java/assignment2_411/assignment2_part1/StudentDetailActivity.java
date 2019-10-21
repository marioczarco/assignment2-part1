package assignment2_411.assignment2_part1;



import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import assignment2_411.assignment2_part1.model.Student;
import assignment2_411.assignment2_part1.model.StudentDB;

public class StudentDetailActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndx;
    protected Student sObj;
    protected final String TAG = "Detail Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        studentIndx = getIntent().getIntExtra("StudentIndex", 0);
        TextView tv = (TextView) findViewById(R.id.display_string_id);

        String origStr = (String) tv.getText();
        tv.setText(origStr + studentIndx);
        tv.setTextSize(24);
        tv.setTextColor(Color.parseColor("#FFFFFF"));
        sObj = StudentDB.getInstance().getStudentList().get(studentIndx);

        EditText editView = (EditText) findViewById(R.id.p_first_name_id);
        editView.setText(sObj.getFirstName());
        editView.setEnabled(false);
        editView = (EditText) findViewById(R.id.p_last_name_id);
        editView.setText(sObj.getLastName());
        editView.setEnabled(false);
        editView = (EditText) findViewById(R.id.p_cwid);
        editView.setText(Integer.valueOf(sObj.getcwid()).toString());
        editView.setEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Custom Menu inflation
        getMenuInflater().inflate(R.menu.detail_screen_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = (EditText) findViewById(R.id.p_first_name_id);
            editView.setEnabled(true);
            editView = (EditText) findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);
            editView = (EditText) findViewById(R.id.p_cwid);
            editView.setEnabled(true);

            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {
            EditText editView = (EditText) findViewById(R.id.p_first_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndx).setFirstName(editView.getText().toString());
            editView.setEnabled(false);
            editView = (EditText) findViewById(R.id.p_last_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndx).setLastName(editView.getText().toString());
            editView.setEnabled(false);
            editView = (EditText) findViewById(R.id.p_cwid);
            StudentDB.getInstance().getStudentList().get(studentIndx).setcwid(Integer.valueOf(editView.getText().toString()));
            editView.setEnabled(false);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);

        }
        return super.onOptionsItemSelected(item);
    }
}
