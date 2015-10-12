/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.view.login;

/**
 *
 * @author ahbaba
 */
public class LoginSession {

    private static LoginSession instance;
    
    private String uName;

    private int uRole;
    
    private LoginSession(){

    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuRole() {
        return uRole;
    }

    public void setuRole(int uRole) {
        this.uRole = uRole;
    }


     public static LoginSession getLoginSession(){
        if(instance == null){
            instance = new LoginSession();
        }
        return instance;
    }

    public void destroyLoginSession(){
        instance = null;
        uName = null;
        uRole= -1;;
    }



}
