#import "PresentationPlugin.h"
#if __has_include(<presentation/presentation-Swift.h>)
#import <presentation/presentation-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "presentation-Swift.h"
#endif

@implementation PresentationPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftPresentationPlugin registerWithRegistrar:registrar];
}
@end
