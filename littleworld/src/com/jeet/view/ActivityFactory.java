package com.jeet.view;

import com.jeet.infra.Activity;
import com.jeet.view.billing.BillingActivity;
import com.jeet.view.billing.PrintableBillingActivity;

public class ActivityFactory {

	public static Activity getActivity(int actId) {
		Activity activity = null;
		switch (actId) {
		case ActivityId.BILLING_TABLE_ACTIVITY:
			activity = new BillingActivity();
			break;
		case ActivityId.BILLING_PRINTABLE_ACTIVITY:
			 activity = new PrintableBillingActivity();
			break;

		default:
			break;
		}
		return activity;
	}

}
