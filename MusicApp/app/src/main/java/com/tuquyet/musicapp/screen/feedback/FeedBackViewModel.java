package com.tuquyet.musicapp.screen.feedback;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.tuquyet.musicapp.BR;
import com.example.tuquyet.musicapp.R;

/**
 * Created by tuquyet on 10/08/2017.
 */
public class FeedBackViewModel extends BaseObservable implements FeedBackContract.ViewModel {
    private Context mContext;
    private String mTextSubject;
    private String mTextMessage;

    public FeedBackViewModel(Context context) {
        mContext = context;
    }

    @Bindable
    public String getTextSubject() {
        return mTextSubject;
    }

    @Bindable
    public String getTextMessage() {
        return mTextMessage;
    }

    public void setTextSubject(String textSubject) {
        mTextSubject = textSubject;
        notifyPropertyChanged(BR.textSubject);
    }

    public void setTextMessage(String textMessage) {
        mTextMessage = textMessage;
        notifyPropertyChanged(BR.textMessage);
    }

    @Override
    public void onSendButtonClicked(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,
            new String[]{mContext.getString(R.string.feedback_email)});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mTextSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mTextMessage);
        emailIntent.setType(mContext.getString(R.string.email_type));
        mContext.startActivity(Intent.createChooser(emailIntent, mContext.getString(R.string
            .choose_app_to_send_email)));
    }
}
