package com.yk.loading;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ClassName: LoadingDialog
 * @Description: 自定义加载等待窗
 * @Author: YangKuan
 * @Date: 2021/2/12 21:44
 */
public class LoadingDialog extends Dialog {

    private LoadingDialog(@NonNull Context context) {
        super(context);
        windowConfig();
    }

    private LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        windowConfig();
    }

    private LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        windowConfig();
    }

    private void windowConfig() {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.BaseDialogWindowAnim);
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(params);
            window.setGravity(Gravity.CENTER);
        }
    }

    public static class Builder {

        private Context context;
        private String message;
        private int textSize = 14;
        @ColorInt
        private int textColor = 0xFFF0F0F0;
        private boolean isShowMessage = true;
        private boolean isCancelable = false;
        private boolean isCancelOutside = false;
        private boolean isBackgroundTransparent = true;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置提示信息
         *
         * @param message
         * @return
         */

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 设置提示信息文字颜色
         *
         * @param color
         * @return
         */
        public Builder setMessageColor(@ColorInt int color) {
            this.textColor = color;
            return this;
        }

        /**
         * 设置提示信息文字字号
         *
         * @param dp
         * @return
         */
        public Builder setMessageSize(int dp) {
            this.textSize = dp;
            return this;
        }

        /**
         * 设置是否显示提示信息
         *
         * @param isShowMessage
         * @return
         */
        public Builder setShowMessage(boolean isShowMessage) {
            this.isShowMessage = isShowMessage;
            return this;
        }

        /**
         * 设置是否可以按返回键取消
         *
         * @param isCancelable
         * @return
         */

        public Builder setCancelable(boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        /**
         * 设置是否可以取消
         *
         * @param isCancelOutside
         * @return
         */
        public Builder setCancelOutside(boolean isCancelOutside) {
            this.isCancelOutside = isCancelOutside;
            return this;
        }

        /**
         * 背景色是否透明
         *
         * @param backgroundTransparent
         */
        public Builder setBackgroundTransparent(boolean backgroundTransparent) {
            this.isBackgroundTransparent = backgroundTransparent;
            return this;
        }

        public LoadingDialog create() {
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
            LoadingDialog loadingDialog = new LoadingDialog(context, isBackgroundTransparent ? R.style.DialogBackgroundTransparent : R.style.DialogBackgroundShadow);
            TextView msgText = (TextView) view.findViewById(R.id.tv_tip_text);
            if (isShowMessage) {
                msgText.setText(message);
                msgText.setVisibility(View.VISIBLE);
            } else {
                msgText.setVisibility(View.GONE);
            }
            msgText.setTextColor(textColor);
            msgText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(isCancelable);
            loadingDialog.setCanceledOnTouchOutside(isCancelOutside);
            return loadingDialog;
        }

    }
}
