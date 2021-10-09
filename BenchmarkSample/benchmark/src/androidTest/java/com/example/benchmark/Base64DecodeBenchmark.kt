/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.benchmark

import android.util.Base64
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.benchmark.impl.*
import com.github.venator85.aklompbase64java.AklompBase64Java
import okio.ByteString.Companion.decodeBase64
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.ByteArrayOutputStream

@LargeTest
@RunWith(AndroidJUnit4::class)
class Base64DecodeBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun androidNative() {
        benchmarkRule.measureRepeated {
            Base64.decode(input, Base64.NO_WRAP)
        }
    }

    @Test
    fun akka() {
        benchmarkRule.measureRepeated {
            val codec = AkkaBase64.rfc2045()
            codec.decode(input)
        }
    }

    @Test
    fun akkaFast() {
        benchmarkRule.measureRepeated {
            val codec = AkkaBase64.rfc2045()
            codec.decodeFast(input)
        }
    }

    @Test
    fun akkaFastSingleLineNoTrim() {
        benchmarkRule.measureRepeated {
            val codec = AkkaBase64.rfc2045()
            codec.decodeFastSingleLineNoTrimIllegals(input)
        }
    }

    @Test
    fun jdk16() {
        benchmarkRule.measureRepeated {
            val codec = Jdk16Base64.getDecoder()
            codec.decode(input)
        }
    }

    @Test
    fun commonsCodec() {
        benchmarkRule.measureRepeated {
            val codec = org.apache.commons.codec.binary.Base64()
            codec.decode(input)
        }
    }

    @Test
    fun datatypeCodec() {
        benchmarkRule.measureRepeated {
            DatatypeConverterImpl.parseBase64Binary(input)
        }
    }

    @Test
    fun okio() {
        benchmarkRule.measureRepeated {
            input.decodeBase64()
        }
    }

	@Test
	fun aklompJni() {
		benchmarkRule.measureRepeated {
            AklompBase64Java.decode(input)
		}
	}

    @Test
    fun midlet() {
        benchmarkRule.measureRepeated {
            MidpBase64.decode(input)
        }
    }

    @Test
    fun aws() {
        benchmarkRule.measureRepeated {
            val bytes = input.toByteArray(Charsets.US_ASCII)
            AwsBase64Codec().decode(bytes, bytes.size)
        }
    }

    @Test
    fun iHarderBase64() {
        benchmarkRule.measureRepeated {
            IHarderBase64.decode(input)
        }
    }

    @Test
    fun bouncycastle() {
        benchmarkRule.measureRepeated {
            val bos = ByteArrayOutputStream().use { bos ->
                BouncycastleBase64Encoder().decode(input, bos)
                bos
            }
            bos.toByteArray()
        }
    }
}
