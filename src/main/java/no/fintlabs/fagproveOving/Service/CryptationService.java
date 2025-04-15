package no.fintlabs.fagproveOving.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class CryptationService {

    private static final String ALGORITHM = "AES";

    @Value("${cryptation.key}")
    private String KEY;

    private SecretKeySpec getKey() {
        return new SecretKeySpec(KEY.getBytes(), ALGORITHM);
    }

    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, getKey());
        byte[] encrypted = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedString) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, getKey());
        byte[] decoded = Base64.getDecoder().decode(encryptedString);
        byte[] decryped = cipher.doFinal(decoded);
        return new String(decryped);
    }


}
