package com.ims.view;

import com.ims.infra.Activity;
import com.ims.view.addSupplier.AddSupplierActivity;
import com.ims.view.addproduct.AddProductActvity;
import com.ims.view.playarea.PlayAreaActivity;
import com.ims.view.billing.PrintableBillingActivity;
import com.ims.view.billingx.BillingActivity;
import com.ims.view.login.UserLoginActivity;
import com.ims.view.welcome.AdminWelcomeActivity;

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
                case ActivityId.LOGIN_ACTIVITY:
                        activity = new UserLoginActivity();
                        break;
                case ActivityId.WELCOME_ACTIVITY:
                        activity = new AdminWelcomeActivity();
                        break;
                case ActivityId.ADD_PRODUCT_ACTIVITY:
                        activity = new AddProductActvity();
                        break;
                case ActivityId.ADD_SUPPLIER_ACTIVITY:
                        activity = new AddSupplierActivity();
                        break;
                    case ActivityId.PLAY_ZONE_ACTIVITY:
                        activity = new PlayAreaActivity();
                        break;
		default:
			break;
		}
		return activity;
	}

}
