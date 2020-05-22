package com.adel.stcpay.presenters;

import android.view.View;

import com.adel.stcpay.MyApplication;
import com.adel.stcpay.R;
import com.adel.stcpay.activities.SenateDetailsActivity;
import com.adel.stcpay.domain.Address;
import com.adel.stcpay.domain.PersonalDetails;
import com.adel.stcpay.domain.Senate;

public class DetailsPresenter {
    private SenateDetailsActivity activity;

    public DetailsPresenter(final SenateDetailsActivity activity) {
        this.activity = activity;

    }
    public void showSenateDetails(Senate s){

        PersonalDetails personalDetails = s.getPersonalDetails();
        Address address = s.getAddress();

        // Determine which Image to show

        int imagePath = R.drawable.democrat_logo;
        if ((s.getParty().equalsIgnoreCase("Republican"))) {
            imagePath = R.drawable.republican_logo;
        }
        // show items for card
        activity.partyIcon.setImageResource(imagePath);
        activity.senatorName.setText(String.format("%s %s", personalDetails.getFirstname(), personalDetails.getLastname()));
        activity.senatorLink.setText(personalDetails.getLink());
        activity.bioLink.setText(personalDetails.getBioGuideId());
        activity.partyName.setText(s.getParty());

        // show items in information block
        activity.addressTv.setText(address.getAddress());
        activity.officeTv.setText(address.getOffice());
        activity.nameTv.setText(personalDetails.getName());
        activity.birthdayTv.setText(personalDetails.getBirthDay());
        activity.endDateTv.setText(s.getEnddate());
        activity.genderTv.setText(personalDetails.getGender());
        activity.sortNameTv.setText(personalDetails.getSortname());
        activity.websiteTv.setText(s.getWebsite());
        activity.phoneTv.setText(s.getPhone());
    }


}
