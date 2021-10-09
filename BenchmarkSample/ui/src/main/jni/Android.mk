TOP_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_PATH := $(TOP_PATH)/akb64_java
LOCAL_C_INCLUDES := $(LOCAL_PATH)
LOCAL_MODULE := akb64_java
LOCAL_SRC_FILES := akb64_java.c  lib/arch/generic/codec.c \
                                 lib/arch/neon32/codec.c \
                                 lib/arch/neon64/codec.c \
                                 lib/arch/ssse3/codec.c \
                                 lib/arch/sse41/codec.c \
                                 lib/arch/sse42/codec.c \
                                 lib/arch/avx/codec.c \
                                 lib/arch/avx2/codec.c \
                                 lib/lib.c \
                                 lib/codec_choose.c \
                                 lib/tables/tables.c

include $(BUILD_SHARED_LIBRARY)
