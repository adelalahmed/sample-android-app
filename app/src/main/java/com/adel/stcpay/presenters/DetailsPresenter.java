package com.adel.stcpay.presenters;

import com.adel.stcpay.R;
import com.adel.stcpay.activities.SenateDetailsActivity;
import com.adel.stcpay.domain.Senate;

public class DetailsPresenter {
    private SenateDetailsActivity activity;

    public DetailsPresenter(SenateDetailsActivity activity) {
        this.activity = activity;
    }

    public void showSenateDetails(Senate s){
        // Determine which Image to show

        int imagePath = R.drawable.democrat_logo;
        if ((s.getParty().equalsIgnoreCase("Republican"))) {
            imagePath = R.drawable.republican_logo;
        }
        // show items for card
        activity.partyIcon.setImageResource(imagePath);
        activity.senatorName.setText(String.format("%s %s", s.getPersonalDetails().getFirstname(), s.getPersonalDetails().getLastname()));
        activity.senatorLink.setText(s.getPersonalDetails().getLink());
        activity.bioLink.setText(s.getPersonalDetails().getBioGuideId());
        activity.partyName.setText(s.getParty());

        // show items in information block
        activity.addressTv.setText(s.getAddress().getAddress());

    }
}
