package com.storeaccount;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import org.ethereum.geth.Account;
import org.ethereum.geth.EthereumClient;
import org.ethereum.geth.NodeInfo;
import org.ethereum.geth.Node;

/**
 * Created by derek on 2/1/18.
 */

public class CreateAccountNativeModule extends ReactContextBaseJavaModule {

    //constructor
    public CreateAccountNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CreateAccountNativeModule";
    }

    @ReactMethod
    public void createAccount(String message, Callback cb) {

        try {
            NodeHolder nodeHolder = NodeHolder.getInstance();
            Node node = nodeHolder.getNode();

            if (node != null) {
                NodeInfo nodeInfo = node.getNodeInfo();
                EthereumClient ethClient = node.getEthereumClient();

                Account newAccount = nodeHolder.getAccount();
                cb.invoke("Here is your Account Address: " + newAccount.getAddress().getHex());
            }
            cb.invoke("node is null");
        } catch (Exception e) {
            Log.d("error: ", e.getMessage());
            e.printStackTrace();
        }
    }
}
