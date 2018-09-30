# KotlinAES256Cipher

#### com.android.tools.build:gradle:3.1.4
#### minSdkVersion 26 ~ targetSdkVersion 28



<a href='https://bintray.com/dbank0208/maven/KotlinAES256Cipher?source=watch' alt='Get automatic notifications about new "KotlinAES256Cipher" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>
 
 
[ ![Download](https://api.bintray.com/packages/dbank0208/maven/KotlinAES256Cipher/images/download.svg) ](https://bintray.com/dbank0208/maven/KotlinAES256Cipher/_latestVersion) 
 

 
https://bintray.com/dbank0208/maven/KotlinAES256Cipher/1.0.3





#### gradle add

```ruby
implementation 'com.dbank0208.KotlinAES256Cipher:KotlinAES256Cipher:1.0.3'
```



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
