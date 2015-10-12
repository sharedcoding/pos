package com.ims.view;

import com.ims.infra.Fragment;
import com.ims.view.billing.BillingActionPaneFragment;
import com.ims.view.billing.BillingInfoPaneFragment;

public class FragmentFactory {

	public static Fragment getFragmnet(int fragId) {
		Fragment frag = null;
		switch (fragId) {
		case FragmentId.BILLING_INFO_FRAGMENT:
			frag = new BillingInfoPaneFragment();
			break;
		case FragmentId.BILLING_ACTION_FRAGMENT:
			frag = new BillingActionPaneFragment();
			break;
		default:
			break;
		}
		return frag;
	}
}
