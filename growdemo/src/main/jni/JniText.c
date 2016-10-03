//
// Created by wuShaoHua on 2016/9/16.
//

#include "beauty_wsh_com_growdemo_jni_JniUtils.h"
JNIEXPORT jstring JNICALL Java_beauty_wsh_com_growdemo_jni_JniUtils_getStringFromC
  (JNIEnv *env, jclass object, jstring str){
        return (*env)->NewStringUTF(env,"this is from C , 懂吗？");
  }
