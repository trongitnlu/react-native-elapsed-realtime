
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNElapsedRealtimeSpec.h"

@interface ElapsedRealtime : NSObject <NativeElapsedRealtimeSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ElapsedRealtime : NSObject <RCTBridgeModule>
#endif

@end
