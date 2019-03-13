package com.rangers.voiceprint;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

//TODO: Simplify Recognizer class code ... IN PROGRESS
public class Navigation {

    public void next(Context context, String text) {
        if (context instanceof Set_Precision) {
            try {
                TextView precision = ((Activity)context).findViewById(R.id.precision_text);
                precision.setText(text);
                Thread.sleep(2000);

//                Intent set_infill = new Intent(context, Set_Infill.class);
//                context.startActivity(set_infill);
//                set_precision.putExtra("PRECISION", text);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (context instanceof Set_Infill) {

            try {
                TextView infill = ((Activity)context).findViewById(R.id.infill_text);
                infill.setText(text);
                wait(2000);
//                Intent set_support = new Intent(context, Set_Support.class);
//                context.startActivity(set_support);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else {
            Log.e("ON RESULT", "NOT SUPPOSED TO HAPPEN");
        }
    }

    //TODO: Method to get layout using current context
    public void getLayout() {

    }
}
