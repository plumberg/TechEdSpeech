#import <Foundation/Foundation.h>

@interface com_hannahryzhuk_techedapp_interfaces_SpeechRecognitionImpl : NSObject {
}

-(NSString*)getResult;
-(void)startListening;
-(BOOL)isSupported;
@end
