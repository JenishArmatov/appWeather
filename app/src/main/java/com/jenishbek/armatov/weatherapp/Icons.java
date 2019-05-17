package com.jenishbek.armatov.weatherapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Icons {
    public Bitmap[] arrayImages;
    Icons(){
    }

    public Bitmap getImage(int number, Context context) {

        arrayImages = new Bitmap[45];
        arrayImages[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_1);
        arrayImages[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_2);
        arrayImages[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_3);
        arrayImages[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_4);
        arrayImages[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_5);
        arrayImages[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_6);
        arrayImages[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_7);
        arrayImages[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_8);
        arrayImages[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_11);
        arrayImages[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_12);
        arrayImages[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_13);
        arrayImages[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_14);
        arrayImages[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_15);
        arrayImages[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_16);
        arrayImages[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_17);
        arrayImages[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_18);
        arrayImages[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_19);
        arrayImages[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_20);
        arrayImages[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_21);
        arrayImages[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_22);
        arrayImages[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_23);
        arrayImages[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_24);
        arrayImages[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_25);
        arrayImages[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_26);
        arrayImages[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_29);
        arrayImages[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_30);
        arrayImages[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_31);
        arrayImages[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_32);
        arrayImages[33] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_33);
        arrayImages[34] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_34);
        arrayImages[35] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_35);
        arrayImages[36] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_36);
        arrayImages[37] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_37);
        arrayImages[38] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_38);
        arrayImages[39] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_39);
        arrayImages[40] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_40);
        arrayImages[41] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_41);
        arrayImages[42] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_42);
        arrayImages[43] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_43);
        arrayImages[44] = BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_44);
        return arrayImages[number];
    }
}

