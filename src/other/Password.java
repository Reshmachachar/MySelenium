package other;

//Base64 class used for encoding and decoding
import org.bouncycastle.util.encoders.Base64;

public class Password {

	public static void main(String[] args) {
		
		String str="test123";
		
		byte[] enstr=Base64.encode(str.getBytes());
		System.out.println("Encoded:"+new String(enstr));
		
		byte[] destr=Base64.decode(enstr);
		System.out.println("decoded:"+new String(destr));
		
		
	}

}
