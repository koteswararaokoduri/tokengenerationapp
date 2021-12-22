import Flutter
import UIKit

public class SwiftTokengenerationPlugin: NSObject, FlutterPlugin {
  weak var weakSelf = self
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "tokengenerationapp", binaryMessenger: registrar.messenger())
    let instance = SwiftTokengenerationappPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    if (call.method == "getPlatformVersion") {
               result("iOS " + UIDevice.current.systemVersion)
    }else if (call.method == "getDeviceToken") {
            let strNative = weakSelf?.appToken()
            result(strNative)
    }

  }
}
