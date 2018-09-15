# KotlinAES256Cipher

#### com.android.tools.build:gradle:3.1.3
#### minSdkVersion 26 ~ targetSdkVersion 28

### generate an unspecified UUID and set the key.
```ruby
class CipherData

val buffer = StringBuilder()
val key = UUID.randomUUID().toString()
val keySplit = key.split("-")

val ivBytes = ByteArray(16)
keySplit.forEach { buffer.append(it) }
```

### Returns the encryption processing string.
```ruby
class MainActivity : AppCompatActivity()

CipherData().cipherData(edit_text.text.toString())[0]
```

### Returns the decryption processing string.
```ruby
class MainActivity : AppCompatActivity() 

CipherData().cipherData(edit_text.text.toString())[1]
```

# GIF
![](https://github.com/daisukenagata/KotlinAES256Cipher/blob/master/movie.gif?raw=true)
