package tw.org.iii.leo.leo22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
//https://github.com/dm77/barcodescanner
public class ScanActivity extends AppCompatActivity
        implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        // this paramter will make your HUAWEI phone works great!
        mScannerView.setAspectTolerance(0.5f);

        setContentView(mScannerView);
        //setContentView(R.layout.activity_scan);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.


        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
//        Log.v("leo", rawResult.getText()); // Prints scan results
//        Log.v("leo", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)


        //重置相機
//        mScannerView.resumeCameraPreview(this);
        setResult(RESULT_OK,new Intent().putExtra("code",rawResult.getText()));
        finish();
    }
}
