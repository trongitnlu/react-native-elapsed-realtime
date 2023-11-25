import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-elapsed-realtime' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const ElapsedRealtime = NativeModules.ElapsedRealtime
  ? NativeModules.ElapsedRealtime
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function getElapsedRealtime(): Promise<number> {
  return ElapsedRealtime.getElapsedRealtime();
}
