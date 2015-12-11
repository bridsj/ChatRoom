package com.zuiapps.chat.room.builder;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class ZUIAlertDialog {
    private String mTitle;

    public void setTitle(String title) {
        mTitle = title;
    }

    public void show() {
    }

    public class ZUIBuilder {
        AlertParam mAlertParam;

        public ZUIBuilder() {
            mAlertParam = new AlertParam();
        }

        public void setTitle(String title) {
            mAlertParam.mTitle = title;
        }

        public ZUIAlertDialog create() {
            ZUIAlertDialog mZUIAlertDialog = new ZUIAlertDialog();
            mZUIAlertDialog.setTitle(mAlertParam.mTitle);
            return mZUIAlertDialog;
        }

        public void show() {
            ZUIAlertDialog dialog = create();
            dialog.show();
        }
    }

    class AlertParam {
        String mTitle;
    }
}
