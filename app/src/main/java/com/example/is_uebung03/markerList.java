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

        if(array[0])
            ((CheckBox) findViewById(R.id.inf_fak)).setChecked(true);
        if(array[1])
            ((CheckBox) findViewById(R.id.alte_mensa)).setChecked(true);
        if(array[2])
            ((CheckBox) findViewById(R.id.neue_mensa)).setChecked(true);
        if(array[3])
            ((CheckBox) findViewById(R.id.nürnberger)).setChecked(true);
        if(array[4])
            ((CheckBox) findViewById(R.id.münchner)).setChecked(true);

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
        System.out.println("View ist: " + view.getId());
        switch (view.getId()) {
            case R.id.inf_fak:
                if (checked)
                    array[0] = true;
                else
                    array[0] = false;
                System.out.println("0" + array[0]);
                break;
            case R.id.alte_mensa:
                if (checked)
                    array[1] = true;
                else
                    array[1] = false;
                System.out.println("1" + array[1]);
                break;
            case R.id.neue_mensa:
                if (checked)
                    array[2] = true;
                else
                    array[2] = false;
                System.out.println("2" + array[2]);
                break;
            case R.id.nürnberger:
                if (checked)
                    array[3] = true;
                else
                    array[3] = false;
                System.out.println("3" + array[3]);
                break;
            case R.id.münchner:
                if (checked)
                    array[4] = true;
                else
                    array[4] = false;
                System.out.println("4" + array[4]);
                break;
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
}
