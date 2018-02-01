package com.storeaccount;

import org.ethereum.geth.Account;
import org.ethereum.geth.Node;

/**
 * Created by derek on 2/1/18.
 */

public class NodeHolder {
    private Node node;
    private Account account;
    private static NodeHolder instance = null;

    private NodeHolder() {
    }

    public static NodeHolder getInstance() {
        if (instance == null) {
            instance = new NodeHolder();
        }
        return instance;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

