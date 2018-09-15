# KotlinAES256Cipher

#### com.android.tools.build:gradle:3.1.3
#### minSdkVersion 26 ~ targetSdkVersion 28

### generate an unspecified UUID and set the key.
```ruby
 val key = UUID.randomUUID().toString()
        val keySplit = key.split("-")
        val buffer = StringBuilder()
        keySplit.forEach {
            buffer.append(it)
        }
```

### Returns the encryption processing string.
```ruby
CipherData().cipherData(edit_text.text.toString())[0]
```

### Returns the decryption processing string.
```ruby
CipherData().cipherData(edit_text.text.toString())[1]
```

# GIF
![](https://github.com/daisukenagata/KotlinAES256Cipher/blob/master/movie.gif?raw=true)
