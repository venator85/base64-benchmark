Base64 Benchmark
===================================

This project measures the performance of various open source implementations.

It uses [AndroidX Benchmark](https://developer.android.com/jetpack/androidx/releases/benchmark).

Currently tested implementations:

* [Akka](https://github.com/akka/akka-http/blob/master/akka-parsing/src/main/java/akka/parboiled2/util/Base64.java)
* [Aklomp Base64](https://github.com/aklomp/base64) (generic implementation). In C, wrapped in a custom made JNI library.
* [AWS Java SDK](https://github.com/aws/aws-sdk-java/blob/master/aws-java-sdk-core/src/main/java/com/amazonaws/util/Base64Codec.java)
* [BouncyCastle](https://github.com/bcgit/bc-java/blob/master/core/src/main/java/org/bouncycastle/util/encoders/Base64Encoder.java)
* [DatatypeConverterImpl from JAXB Reference Implementation](https://github.com/eclipse-ee4j/jaxb-ri/blob/master/jaxb-ri/runtime/impl/src/main/java/org/glassfish/jaxb/runtime/DatatypeConverterImpl.java)
* [IHarder](http://iharder.sourceforge.net/current/)
* [MIDP](http://jcs.mobile-utopia.com/jcs/8186_Base64.java) (J2ME)
* [OpenJDK Base64](https://github.com/openjdk/jdk16u/blob/master/src/java.base/share/classes/java/util/Base64.java)

## Running

Open the project in Android Studio 3.4 or later, and run benchmarks as you
usually would run tests: Ctrl-Shift-F10 (Mac: Ctrl-Shift-R)


## Results

The following results were obtained by decoding **100 KiB** (102,400 bytes) of random data.

### OnePlus 9 Pro - Android 11

      279,512   ns           2 allocs    Base64DecodeBenchmark.aklompJni
      524,134   ns          19 allocs    Base64DecodeBenchmark.bouncycastle
      372,648   ns           4 allocs    Base64DecodeBenchmark.androidNative
      238,029   ns           1 allocs    Base64DecodeBenchmark.midlet
      140,751   ns           1 allocs    Base64DecodeBenchmark.akkaFastSingleLineNoTrim
      804,123   ns           4 allocs    Base64DecodeBenchmark.aws
      427,601   ns           1 allocs    Base64DecodeBenchmark.akka
      867,171   ns           2 allocs    Base64DecodeBenchmark.okio
      338,865   ns           2 allocs    Base64DecodeBenchmark.jdk16
      632,318   ns           4 allocs    Base64DecodeBenchmark.iHarderBase64
      143,091   ns           1 allocs    Base64DecodeBenchmark.akkaFast
      284,579   ns           2 allocs    Base64DecodeBenchmark.datatypeCodec
      952,097   ns           9 allocs    Base64DecodeBenchmark.commonsCodec

### ZTE Blade A5 2019 - Android 9

    2,033,245   ns           2 allocs    Base64DecodeBenchmark.aklompJni
    3,132,003   ns          19 allocs    Base64DecodeBenchmark.bouncycastle
    3,643,477   ns           4 allocs    Base64DecodeBenchmark.androidNative
    2,177,371   ns           1 allocs    Base64DecodeBenchmark.midlet
    1,413,452   ns           1 allocs    Base64DecodeBenchmark.akkaFastSingleLineNoTrim
    6,442,409   ns           4 allocs    Base64DecodeBenchmark.aws
    3,992,215   ns           1 allocs    Base64DecodeBenchmark.akka
    2,974,929   ns           2 allocs    Base64DecodeBenchmark.okio
    2,530,910   ns           2 allocs    Base64DecodeBenchmark.jdk16
    5,723,019   ns           4 allocs    Base64DecodeBenchmark.iHarderBase64
    1,418,783   ns           1 allocs    Base64DecodeBenchmark.akkaFast
    2,399,417   ns           2 allocs    Base64DecodeBenchmark.datatypeCodec
    9,902,653   ns           9 allocs    Base64DecodeBenchmark.commonsCodec

### Samsung Galaxy A51 - Android 11

      887,436   ns           2 allocs    Base64DecodeBenchmark.aklompJni
    1,755,395   ns          19 allocs    Base64DecodeBenchmark.bouncycastle
    1,521,838   ns           4 allocs    Base64DecodeBenchmark.androidNative
    1,038,755   ns           1 allocs    Base64DecodeBenchmark.midlet
      578,713   ns           1 allocs    Base64DecodeBenchmark.akkaFastSingleLineNoTrim
    2,679,966   ns           4 allocs    Base64DecodeBenchmark.aws
    1,686,964   ns           1 allocs    Base64DecodeBenchmark.akka
    1,794,196   ns           1 allocs    Base64DecodeBenchmark.okio
    1,231,435   ns           2 allocs    Base64DecodeBenchmark.jdk16
    2,608,189   ns           4 allocs    Base64DecodeBenchmark.iHarderBase64
      581,452   ns           1 allocs    Base64DecodeBenchmark.akkaFast
    1,151,418   ns           2 allocs    Base64DecodeBenchmark.datatypeCodec
    3,877,281   ns           9 allocs    Base64DecodeBenchmark.commonsCodec

License
-------

Copyright 2021 Alessio Bianchi

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
