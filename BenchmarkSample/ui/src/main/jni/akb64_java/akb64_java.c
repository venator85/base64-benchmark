#include <stdlib.h>
#include <string.h>
#include <jni.h>
#include "include/libbase64.h"

JNIEXPORT void JNICALL Java_com_github_venator85_aklompbase64java_AklompBase64Java_decode( JNIEnv* env, jobject thiz,
		jbyteArray encoded, jbyteArray output) {

	jbyte* encodedAr = (*env)->GetByteArrayElements(env, encoded, NULL);
	int encodedLen = (*env)->GetArrayLength(env, encoded);

	jbyte* outputAr = (*env)->GetByteArrayElements(env, output, NULL);
	int outputLen = (*env)->GetArrayLength(env, output);

	size_t outLen;
    base64_decode((const char*) encodedAr, encodedLen, (char*) outputAr, &outLen, 0);

	if (encodedAr != NULL) (*env)->ReleaseByteArrayElements(env, encoded, encodedAr, 0);
	if (outputAr != NULL) (*env)->ReleaseByteArrayElements(env, output, outputAr, 0);
}
