package com.example.is_uebung03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;

public class markerList extends Activity {

    boolean[] array = new boolean[5];
    public String key = "auswertung";
    private int sendCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.marker_list);
        array  = getIntent().getBooleanArrayExtra("zustand");
        System.out.println(array);

        View mCheckboxFakultät = (CheckBox) findViewById(R.id.inf_fak);
        View mCheckboxAlteMensa = (CheckBox) findViewById(R.id.alte_mensa);
        View mCheckboxNeueMensa = (CheckBox) findViewById(R.id.neue_mensa);
        View mCheckboxNürnberger = (CheckBox) findViewById(R.id.nürnberger);
        View mCheckboxMünchner = (CheckBox) findViewById(R.id.münchner);

        onCheckboxClicked(mCheckboxFakultät);
        onCheckboxClicked(mCheckboxAlteMensa);
        onCheckboxClicked(mCheckboxNeueMensa);
        onCheckboxClicked(mCheckboxNürnberger);
        onCheckboxClicked(mCheckboxMünchner);



        Bundle b = new Bundle();
        b.putBooleanArray(key, array);
        Intent i = new Intent();
        i.putExtras(b);
        setResult(sendCounter, i);
        //finish();


    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.inf_fak:
                if (checked)
                    array[0] = true;
                else
                    array[0] = false;
            case R.id.alte_mensa:
                if (checked)
                    array[1] = true;
                else
                    array[1] = false;
            case R.id.neue_mensa:
                if (checked)
                    array[2] = true;
                else
                    array[2] = false;
            case R.id.nürnberger:
                if (checked)
                    array[3] = true;
                else
                    array[3] = false;
            case R.id.münchner:
                if (checked)
                    array[4] = true;
                else
                    array[4] = false;
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void checkForSaves(boolean array[]){

    }
}
