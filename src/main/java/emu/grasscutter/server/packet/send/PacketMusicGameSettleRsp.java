package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameSettleRspOuterClass;

public class PacketMusicGameSettleRsp extends BasePacket {

	public PacketMusicGameSettleRsp(int musicBasicId) {
		super(PacketOpcodes.MusicGameSettleRsp);

		var proto = MusicGameSettleRspOuterClass.MusicGameSettleRsp.newBuilder();

		proto.setMusicBasicId(musicBasicId)
				.setIsNewRecord(true);

		this.setData(proto);
	}
}
