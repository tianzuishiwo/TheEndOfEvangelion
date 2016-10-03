//
// Created by wuShaoHua on 2016/9/16.
//

#include "beauty_wsh_com_theendofevangelion_jni_MyJniUtils.h"
JNIEXPORT jstring JNICALL Java_beauty_wsh_com_theendofevangelion_jni_MyJniUtils_getStringFromCS2
  (JNIEnv *env, jclass object, jstring str){
        return (*env)->NewStringUTF(env,"this is from C Are you  明白？");
  }