package com.hebth.mobilelibrary.ui.saoyisao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebth.mobilelibrary.ui.ebookdetail.view.EBookDetailActivity;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.karics.library.zxing.android.CaptureActivity;

public class RQActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SCAN = 0x0000;

    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";

    private TextView qrCoded;
    private ImageView qrCodeImage;
    private Button creator, scanner;
    private EditText qrCodeUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(RQActivity.this,
                CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
//        setContentView(R.layout.activity_rq);
//
//        qrCoded = (TextView) findViewById(R.id.ECoder_title);
//        qrCodeImage = (ImageView) findViewById(R.id.ECoder_image);
//        creator = (Button) findViewById(R.id.ECoder_creator);
//        scanner = (Button) findViewById(R.id.ECoder_scaning);
//        qrCodeUrl = (EditText) findViewById(R.id.ECoder_input);

//        creator.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                String url = qrCodeUrl.getText().toString();
//                try {
//                    Bitmap bitmap = CodeCreator.createQRCode(url);
//                    qrCodeImage.setImageBitmap(bitmap);
//                } catch (WriterException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//
//        scanner.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(RQActivity.this,
//                        CaptureActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_SCAN);
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                String[] split = content.split("\\?");
                if (split[0] == null && split[0].length() == 0) {
                    split[0] = "";
                }
                if (split.length > 1) {
                    startActivity(EBookDetailActivity.getDetailActivity(this, split[1]));
                } else {
//                    startActivity(BookDetailActivity.getBookDetailIntent(this, BookDetailActivity.ISBNSEARCH, split[0]));
                    ToastUtils.showText(this, "该条码无效..");
                }
            }
        }
        this.finish();
    }
}
