package defanging_an_ip_address_1108;

public class Main {

	public static void main(String args[]) {

		System.out.println(defangIPaddr("1.2.3.4"));

	}

	public static String defangIPaddr(String address) {

		if(address.length() == 0)
			return address;

		String strings[] = address.split("\\.");

		address = strings[0] + "[" + "." + "]" + strings[1] + "[" + "." + "]" + strings[2] + "[" + "." + "]"
				+ strings[3];

		return address;

	}

}
