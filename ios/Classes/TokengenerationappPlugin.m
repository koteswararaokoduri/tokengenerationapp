#import "TokengenerationappPlugin.h"
#if __has_include(<tokengenerationapp/tokengenerationapp-Swift.h>)
#import <tokengenerationapp/tokengenerationapp-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "tokengenerationapp-Swift.h"
#endif

@implementation TokengenerationappPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftTokengenerationappPlugin registerWithRegistrar:registrar];
}
@end
