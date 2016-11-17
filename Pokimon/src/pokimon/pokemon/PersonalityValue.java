package pokimon.pokemon;

import java.util.Random;

public class PersonalityValue {
	private byte[] pv;

	public enum ByteRange {
		FIRST, SECOND, THIRD, FOURTH
	}

	public PersonalityValue() {
		// TODO Diese Art des generierens kann und sollte sp�ter �berarbeitet
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
			//TODO Verwende einen Logger hierf�r
			System.out.println(
					"!PersonalityValue!\nKonnte kein Byte zur�ck geben, da kein korrekter Case ausgew�hlt wurde.");
		}

		return b;
	}

}
