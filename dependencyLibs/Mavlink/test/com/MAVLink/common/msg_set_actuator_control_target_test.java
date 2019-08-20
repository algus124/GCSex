/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */
         
// MESSAGE SET_ACTUATOR_CONTROL_TARGET PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Parser;
import com.MAVLink.ardupilotmega.CRC;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
* Set the vehicle attitude and body angular rates.
*/
public class msg_set_actuator_control_target_test{

public static final int MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET = 139;
public static final int MAVLINK_MSG_LENGTH = 43;
private static final long serialVersionUID = MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET;

private Parser parser = new Parser();

public CRC generateCRC(byte[] packet){
    CRC crc = new CRC();
    for (int i = 1; i < packet.length - 2; i++) {
        crc.update_checksum(packet[i] & 0xFF);
    }
    crc.finish_checksum(MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET);
    return crc;
}

public byte[] generateTestPacket(){
    ByteBuffer payload = ByteBuffer.allocate(6 + MAVLINK_MSG_LENGTH + 2);
    payload.put((byte)MAVLinkPacket.MAVLINK_STX); //stx
    payload.put((byte)MAVLINK_MSG_LENGTH); //len
    payload.put((byte)0); //seq
    payload.put((byte)255); //sysid
    payload.put((byte)190); //comp id
    payload.put((byte)MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET); //msg id
    payload.putLong((long)93372036854775807L); //time_usec
    //controls
    payload.putFloat((float)73.0);
    payload.putFloat((float)74.0);
    payload.putFloat((float)75.0);
    payload.putFloat((float)76.0);
    payload.putFloat((float)77.0);
    payload.putFloat((float)78.0);
    payload.putFloat((float)79.0);
    payload.putFloat((float)80.0);
    payload.put((byte)125); //group_mlx
    payload.put((byte)192); //target_system
    payload.put((byte)3); //target_component
    
    CRC crc = generateCRC(payload.array());
    payload.put((byte)crc.getLSB());
    payload.put((byte)crc.getMSB());
    return payload.array();
}

@Test
public void test(){
    byte[] packet = generateTestPacket();
    for(int i = 0; i < packet.length - 1; i++){
        parser.mavlink_parse_char(packet[i] & 0xFF);
    }
    MAVLinkPacket m = parser.mavlink_parse_char(packet[packet.length - 1] & 0xFF);
    byte[] processedPacket = m.encodePacket();
    assertArrayEquals("msg_set_actuator_control_target", processedPacket, packet);
}
}
        