package com.example.qrcode_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(btn_ok);
    }

    private Button.OnClickListener btn_ok = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            genCode(v);

        }
    };

    public void genCode(View view) {
        EditText input = (EditText) findViewById(R.id.input);
        ImageView image_view = (ImageView) findViewById(R.id.image_view);
        BarcodeEncoder encoder = new BarcodeEncoder();
        try {
            Bitmap bit = encoder.encodeBitmap(input.getText().toString(), BarcodeFormat.QR_CODE,
                    250, 250);
            image_view.setImageBitmap(bit);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

}
