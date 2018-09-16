# KotlinAES256Cipher

#### com.android.tools.build:gradle:3.1.3
#### minSdkVersion 26 ~ targetSdkVersion 28

## how to build.gradle

#### apply plugin: 'com.android.library' -> apply plugin: 'com.android.application'

## Introduction

#### Two EditText set values in array.
#### One decrypts it with a fixed Test.
#### The second is decrypting with the entered value.
#### The third one encrypts the entered value.


## Method introduction
### generate an unspecified UUID and set the key.
```ruby
class CipherData

val buffer = StringBuilder()
val key = UUID.randomUUID().toString()
val keySplit = key.split("-")

val ivBytes = ByteArray(16)
keySplit.forEach { buffer.append(it) }
```
### The value of the specified element is returned.
```ruby
class MainActivity : AppCompatActivity()

text_view.text = CipherData().cipherData(textArray)[EnumCount.Test.number]
```

### The entered value is returned.
```ruby
class MainActivity : AppCompatActivity()

text_view.text = CipherData().cipherData(textArray)[EnumCount.Value.number]
```

### Returns the encrypted value.

```ruby
class MainActivity : AppCompatActivity() 

CipherData().cipherData(edit_text.text.toString()) 
```

# GIF
![](https://github.com/daisukenagata/KotlinAES256Cipher/blob/master/movie.gif?raw=true)
