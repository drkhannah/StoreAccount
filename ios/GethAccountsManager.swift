//
//  GethAddresses.swift
//  AddressStoreage
//
//  Created by Derek Hannah on 1/30/18.
//  Copyright © 2018 Facebook. All rights reserved.
//

import Geth

@objc(GethAccountsManager)
class GethAccountsManager: NSObject {
  
  @objc(password:)
  func createNewAccount(password: String) -> Void {
    // The path to the keystore folder needs to be a location that is writable by the local mobile application but non-readable for other installed applications (for security reasons obviously), so we'd recommend placing it inside your app's document directory
    let datadir = NSSearchPathForDirectoriesInDomains(.documentDirectory, .userDomainMask, true)[0]
    
    // create a new encrypted account manager
    let ks = GethNewKeyStore(datadir + "/keystore", GethLightScryptN, GethLightScryptP);
    
    // Create a new account with the specified encryption passphrase.
    let newAcc = try! ks?.newAccount(password)
    print (newAcc!)
  }
}
