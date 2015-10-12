package com.ims.controller;

import java.io.IOException;

import com.ims.infra.IBinder;
import com.ims.infra.Service;

public class CountingService extends Service {
	private boolean canContinue = true;

	protected IBinder onBind() {
		return new Binder();
	}

	protected void onServiceStart() {
		super.onServiceStart();
		int i = 0;
		while (canContinue) {
			System.out.println("CountingService.onServiceStart()" + i++);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	class Binder implements IBinder {

		public void actionOnService(int actionId) {
			System.out.println("CountingService.Binder.updateAction()");
			if (actionId == STOP) {
				canContinue = false;
			}
		}

	}
}
