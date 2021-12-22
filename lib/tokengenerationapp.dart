
import 'dart:async';

import 'package:flutter/services.dart';

class Tokengeneration {
  static const MethodChannel _channel = MethodChannel('tokengenerationapp');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String?> get deviceToken async {
    final String? version = await _channel.invokeMethod('getDeviceToken');
    return version;
  }

}
