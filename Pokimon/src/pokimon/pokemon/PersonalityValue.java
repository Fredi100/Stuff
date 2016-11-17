package pokimon.pokemon;

import java.util.Random;

public class PersonalityValue {
	private byte[] pv;

	public enum ByteRange {
		FIRST, SECOND, THIRD, FOURTH
	}

	public PersonalityValue() {
		// TODO Diese Art des generierens kann und sollte später überarbeitet
		// werden da sie nicht sicher ist.
		pv = new byte[4];
		new Random().nextBytes(pv);
	}

	public byte getPVByte(ByteRange e) {
		byte b = 0;
		switch (e) {
		case FIRST:
			b = pv[0];
			break;
		case SECOND:
			b = pv[1];
			break;
		case THIRD:
			b = pv[2];
			break;
		case FOURTH:
			b = pv[3];
			break;
		default:
			//TODO Verwende einen Logger hierfür
			System.out.println(
					"!PersonalityValue!\nKonnte kein Byte zurück geben, da kein korrekter Case ausgewühlt wurde.");
		}

		return b;
	}

}
