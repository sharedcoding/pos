package com.ims.controller;

import java.io.IOException;

import com.ims.infra.Service;

public class MusicService extends Service {

	public void onServiceStart(){
		super.onServiceStart();
		 try {
				Process ps=Runtime.getRuntime().exec("java -jar C:\\Users\\jatindera\\Downloads\\SwingAudioPlayer\\SwingAudioPlayer\\SwingAudioPlayer.jar");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
}
