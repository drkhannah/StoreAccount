package com.storeaccount;

import android.os.Bundle;
import android.util.Log;

import com.facebook.react.ReactActivity;

import org.ethereum.geth.Account;
import org.ethereum.geth.Geth;
import org.ethereum.geth.KeyStore;
import org.ethereum.geth.Node;
import org.ethereum.geth.NodeConfig;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "StoreAccount";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            NodeConfig nc = new NodeConfig();
            Node node = Geth.newNode(getFilesDir() + "/.ethNode", nc);
            node.start();

            NodeHolder nodeHolder = NodeHolder.getInstance();
            nodeHolder.setNode(node);

            KeyStore ks = new KeyStore(getFilesDir() + "/keystore", Geth.LightScryptN, Geth.LightScryptP);
            Account newAccount = ks.newAccount("Password");

            Log.d("account address: ", newAccount.getAddress().getHex());
            nodeHolder.setAccount(newAccount);

        } catch (Exception e) {
            Log.e("error: ", e.getMessage());
            e.printStackTrace();
        }
    }
}
