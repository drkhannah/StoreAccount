//
//  GethAccountsBridge.m
//  AddressStoreage
//
//  Created by Derek Hannah on 1/30/18.
//  Copyright © 2018 Facebook. All rights reserved.
//

#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(GethAccountsManager, NSObject)

RCT_EXTERN_METHOD(createNewAccount:(NSString *)password)

@end
