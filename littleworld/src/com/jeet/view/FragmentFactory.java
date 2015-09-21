package com.jeet.view;

import com.jeet.infra.Fragment;
import com.jeet.view.billing.BillingActionPaneFragment;
import com.jeet.view.billing.BillingInfoPaneFragment;

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
