package drucc.sittichok.heyheybread;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

public class Barcode extends AppCompatActivity {
    private ImageView imageView;
    private String idString, idBarcode;
    private TextView Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        idString = getIntent().getStringExtra("ID");
        idBarcode = getIntent().getStringExtra("IDbarcode");

        imageView = (ImageView) findViewById(R.id.imageView11);
        Text = (TextView) findViewById(R.id.textView60);

        setBarcode(idBarcode);

        Text.setText(idBarcode);
    }

    private void setBarcode(String strIdBarcode) {

        try {

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(strIdBarcode,BarcodeFormat.CODE_128,700,300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }

    }   // setBarcode

    public void finishBarcode(View v) {

        Intent objIntent = new Intent(Barcode.this, HubActivity.class);
        objIntent.putExtra("ID", idString);
        startActivity(objIntent);
        finish();
    }
}
