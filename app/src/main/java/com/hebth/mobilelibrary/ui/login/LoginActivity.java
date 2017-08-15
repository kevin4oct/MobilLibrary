package com.hebth.mobilelibrary.ui.login;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hebth.mobilelibrary.R;
import com.hebth.mobilelibrary.ui.base.BaseActivity;
import com.hebth.mobilelibrary.ui.login.net.LoginRequestParams;
import com.hebth.mobilelibrary.ui.main.activitys.MainActivity;
import com.hebth.mobilelibrary.utils.CommenUtils;
import com.hebth.mobilelibrary.utils.SharedPreferenceUtil;
import com.hebth.mobilelibrary.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static com.hebth.mobilelibrary.ui.ebookdetail.view.EBookDetailActivity.GALLERY_REQUEST;

/**
 * 欢迎界面，用于登录，设置权限
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @ViewInject(R.id.username_welcome)
    private EditText username_et;
    @ViewInject(R.id.password_welcome)
    private EditText password_et;
    @ViewInject(R.id.btn_login_welcome)
    private Button loginBtn;

    public static Intent getLoginIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    //权限列表
    public static final String[] PrimissionList = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.VIBRATE};

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (grantResults != null && grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //执行授权之后的代码
//                    getLocalBooks();
                } else {
//                    Toast.makeText(this, "您未授予访问本地存储空间的权限，书架功能受限..",
//                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }


    @Override
    public void beforeSetContentView() {
        super.beforeSetContentView();
        //设置主题
        setTheme(R.style.Welcom);
    }

    @Override
    public void initView() {

        //权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            new AlertDialog.Builder(this).setTitle("提示")
                    .setMessage(getResources().getString(R.string.app_name)
                            + "需要使用这些权限，拒绝可能到导致软件不能正常使用")
                    .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(LoginActivity.this, PrimissionList, GALLERY_REQUEST);
                        }
                    })
                    .setCancelable(false)
                    .show();


        } else {
            //// TODO: 2017-06-20 files为0 使用存储空间的权限
//            getLocalBooks();
        }


        //判断是否登录过
        if (CommenUtils.isEmpty(SharedPreferenceUtil.getUsername())
                && CommenUtils.isEmpty(SharedPreferenceUtil.getPassword())) {
            //登陆过，填充用户名和密码
            username_et.setText(SharedPreferenceUtil.getUsername());
            password_et.setText(SharedPreferenceUtil.getPassword());
        }
//        else {
        //没有登录过，神马也不做
//        }
    }

    @Override
    public void initListener() {
        //
        loginBtn.setOnClickListener(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_welcome:
                String username = username_et.getText().toString();
                if (!CommenUtils.isEmpty(username)) {
                    ToastUtils.showText(this, "请输入用户名！");
                    return;
                }
                String password = password_et.getText().toString();
                if (!CommenUtils.isEmpty(password)) {
                    ToastUtils.showText(this, "请输入密码！");
                    return;
                }
                login(username, password);
                break;
        }
    }

    /**
     * 登录的网络请求
     *
     * @param carnNum
     * @param password
     */
    public void login(final String carnNum, final String password) {
        LoginRequestParams params = new LoginRequestParams();
        params.cardNum = carnNum;
        params.password = password;

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (CommenUtils.isEmpty(result)) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        String success = jsonObject.getString("success");
                        if ("true".equals(success)) {
                            ToastUtils.showText(LoginActivity.this, "登陆成功..");
                            //保存登录信息
                            SharedPreferenceUtil.saveLoginInfo(carnNum, password);
                            //跳转页面
                            toMainActivity();
                        } else {
                            ToastUtils.showText(LoginActivity.this, "登陆失败..");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    ToastUtils.showText(LoginActivity.this, "发生网络错误..");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.e(ex.getMessage());
                ToastUtils.showText(LoginActivity.this, "发生网络错误..");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 跳转
     */
    private void toMainActivity() {
        startActivity(MainActivity.getMainIntent(this));
//        overridePendingTransition(R.anim.login_in_set, 0);

        this.finish();
    }
}
